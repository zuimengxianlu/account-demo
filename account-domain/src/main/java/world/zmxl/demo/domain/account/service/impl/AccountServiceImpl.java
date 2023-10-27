package world.zmxl.demo.domain.account.service.impl;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.zmxl.demo.domain.account.model.entity.Account;
import world.zmxl.demo.domain.account.model.valobj.AccountTransferVO;
import world.zmxl.demo.domain.account.model.valobj.QueryAccountMoneyVO;
import world.zmxl.demo.domain.account.repository.IAccountRepository;
import world.zmxl.demo.domain.account.service.IAccountService;
import world.zmxl.demo.domain.user.model.entity.UserInfo;
import world.zmxl.demo.domain.user.repository.IUserRepository;
import world.zmxl.demo.types.constant.LockConstants;
import world.zmxl.demo.types.enm.AccountMoneySourceType;
import world.zmxl.demo.types.exception.AcquireLockException;
import world.zmxl.demo.types.response.PagingResult;
import world.zmxl.demo.types.response.Result;
import world.zmxl.demo.types.response.data.PagingData;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Service
public class AccountServiceImpl implements IAccountService, LockConstants {

    @Resource(type = IAccountRepository.class)
    private IAccountRepository accountRepository;

    @Resource(type = IUserRepository.class)
    private IUserRepository userRepository;

    @Resource(type = RedissonClient.class)
    private RedissonClient redissonClient;

    @AllArgsConstructor
    @Getter
    private enum CheckMsgTemplate {

        DEFAULT("未查询到用户信息", "未开通账户", "账户待激活"),

        TRANSFER("未查询到用户'{}'信息", "用户'{}'未开通账户", "用户'{}'账户待激活");

        private final String arg0;

        private final String arg1;

        private final String arg2;

    }

    private Result<BigDecimal> checkUserAndAccountIsAvailableAndReturnBalance(@NonNull Long uid, @NotNull CheckMsgTemplate template) {
        // 1. 获取用户信息，不存在则提示无该用户信息
        UserInfo userInfo = userRepository.selectUserInfo(uid);
        if (userInfo == null) {
            return Result.error(template.arg0, uid);
        }

        // 2. 获取账户信息，不存在则提示未开户，存在且锁定则提示待激活
        Account account = accountRepository.selectUserAccount(uid);
        if (account == null) {
            return Result.error(template.arg1, userInfo.getName());
        }

        if (account.isLocked()) {
            return Result.error(template.arg2, userInfo.getName());
        }

        return Result.success(account.getBalance());
    }

    @Override
    public Result<BigDecimal> getAccount(Long uid) {
        // 1. 2. 3. 返回账户余额
        return checkUserAndAccountIsAvailableAndReturnBalance(uid, CheckMsgTemplate.DEFAULT);
    }

    @Override
    public Result<PagingData<?>> showAccountMoney(QueryAccountMoneyVO queryParams) {
        // 1. 获取用户信息，不存在则提示无该用户信息

        // 2. 获取账户信息，不存在则提示未开户，存在且锁定则提示待激活

        // 3. 根据查询条件筛选账户明细并返回

        return PagingResult.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> accountTransfer(AccountTransferVO body) {
        List<RLock> locks = new LinkedList<>();
        try {
            // Transactional start
            // lock source user and source user account
            lock(body.getUid(), locks);
            // 1. 获取转出用户信息，不存在则提示无该用户信息
            // 2. 获取转出账户信息，不存在则提示未开户，存在且锁定则提示待激活
            Result<BigDecimal> checkRes = checkUserAndAccountIsAvailableAndReturnBalance(body.getUid(), CheckMsgTemplate.DEFAULT);

            if (!checkRes.isSuccess()) {
                return checkRes;
            }
            // 3. 余额验证
            if (checkRes.getData().subtract(body.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
                return Result.error("余额不足");
            }
            // lock target user and target user account
            lock(body.getTargetUid(), locks);
            // 4. 获取转入账户信息，不存在则提示无该用户信息
            // 5. 获取转入账户信息，不存在则提示未开户，存在且锁定则提示待激活

            checkRes = checkUserAndAccountIsAvailableAndReturnBalance(body.getTargetUid(), CheckMsgTemplate.TRANSFER);

            if (!checkRes.isSuccess()) {
                return checkRes;
            }

            // 6. 转出账户移除对应金额
            accountRepository.updateBalance(body.getUid(), body.getAmount(), AccountMoneySourceType.TRANSFER_OUT);

            // 7. 转入账户移除对应金额
            accountRepository.updateBalance(body.getTargetUid(), body.getAmount(), AccountMoneySourceType.TRANSFER_IN);

        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            for (RLock lock : locks) {
                if (lock != null && lock.isLocked() && lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
        return Result.success();
    }

    private void lock(Long uid, List<RLock> locks) throws InterruptedException {
        RLock targetAccountLock = redissonClient.getLock(StrUtil.format(LOCK_ACCOUNT, uid));
        RLock targetUserLock = redissonClient.getLock(StrUtil.format(LOCK_USER, uid));
        if (!targetAccountLock.tryLock(5, TimeUnit.SECONDS)) {
            throw new AcquireLockException(targetAccountLock.getName());
        }
        locks.add(targetAccountLock);
        if (!targetUserLock.tryLock(5, TimeUnit.SECONDS)) {
            throw new AcquireLockException(targetUserLock.getName());
        }
        locks.add(targetUserLock);
    }


}
