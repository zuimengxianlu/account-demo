package world.zmxl.demo.domain.account.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.zmxl.demo.domain.account.model.valobj.AccountTransferVO;
import world.zmxl.demo.domain.account.model.valobj.QueryAccountMoneyVO;
import world.zmxl.demo.domain.account.repository.IAccountRepository;
import world.zmxl.demo.domain.account.service.IAccountService;
import world.zmxl.demo.types.response.PagingResult;
import world.zmxl.demo.types.response.Result;
import world.zmxl.demo.types.response.data.PagingData;

import java.math.BigDecimal;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource(type = IAccountRepository.class)
    private IAccountRepository accountRepository;

    @Override
    public Result<BigDecimal> getAccount(Long uid) {
        // 1. 获取用户信息，不存在则提示无该用户信息

        // 2. 获取账户信息，不存在则提示未开户，存在且锁定则提示待激活

        // 3. 返回账户余额

        return Result.success(BigDecimal.ZERO);
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
    public Result<?> accountTransfer(AccountTransferVO accountTransferBody) {
        // Transactional start

        // lock source user and source user account

        // 1. 获取转出用户信息，不存在则提示无该用户信息

        // 2. 获取转出账户信息，不存在则提示未开户，存在且锁定则提示待激活

        // lock target user and target user account

        // 3. 获取转入账户信息，不存在则提示无该用户信息

        // 4. 获取转入账户信息，不存在则提示未开户，存在且锁定则提示待激活

        // lock target user account and source user account

        // 5. 验证余额

        // 6. 转出账户移除对应金额

        // 7. 转入账户移除对应金额

        // locks unlock

        // Transactional end
        return Result.success();
    }
}
