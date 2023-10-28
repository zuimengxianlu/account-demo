package world.zmxl.demo.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import world.zmxl.demo.domain.account.model.entity.AccountDTO;
import world.zmxl.demo.domain.account.model.entity.AccountMoneyDTO;
import world.zmxl.demo.domain.account.model.entity.UpdateAccountDTO;
import world.zmxl.demo.domain.account.model.valobj.QueryAccountMoneyVO;
import world.zmxl.demo.domain.account.repository.IAccountRepository;
import world.zmxl.demo.infrastructure.dao.IAccountDao;
import world.zmxl.demo.infrastructure.dao.IAccountMoneyDao;
import world.zmxl.demo.infrastructure.entity.Account;
import world.zmxl.demo.infrastructure.entity.AccountMoney;
import world.zmxl.demo.types.constant.CacheKeyConstants;
import world.zmxl.demo.types.enm.AccountMoneySourceType;
import world.zmxl.demo.types.enm.BooleanEnum;
import world.zmxl.demo.types.exception.DatabaseException;
import world.zmxl.demo.types.response.data.PagingData;

import java.util.stream.Collectors;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Repository
public class AccountRepository implements IAccountRepository, CacheKeyConstants {

    @Resource(type = IAccountDao.class)
    private IAccountDao accountDao;

    @Resource(type = IAccountMoneyDao.class)
    private IAccountMoneyDao accountMoneyDao;

    @Override
    public AccountDTO selectUserAccount(@NotNull Long uid) {
        Account account = accountDao.selectOne(Wrappers.lambdaQuery(Account.class)
                .eq(Account::getUid, uid));

        return AccountDTO.builder()
                .uid(account.getUid())
                .balance(account.getBalance())
                .locked(BooleanEnum.isTrue(account.getIsLocked()))
                .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBalance(UpdateAccountDTO dto) {

        if (accountDao.update(null, Wrappers.lambdaUpdate(Account.class)
                .eq(Account::getUid, dto.getUid())
                .set(Account::getBalance, dto.getBalance())) != 1) {
            throw DatabaseException.updateError("account balance, dto : {}", dto);
        }

        if (accountMoneyDao.insert(AccountMoney.builder()
                .uid(dto.getUid())
                .money(dto.getMoney())
                .balance(dto.getBalance())
                .sourceId(dto.getSourceId())
                .sourceType(dto.getSourceType().getKey())
                .sourceBody(dto.getSourceBody()).build()) != 1) {
            throw DatabaseException.insertError("account balance money, dto : {}", dto);
        }
    }

    @Override
    public PagingData<AccountMoneyDTO> selectUserAccountMoney(QueryAccountMoneyVO queryParams) {
        IPage<AccountMoney> page = new PagingData<>();

        page.setCurrent(queryParams.getPage())
            .setSize(queryParams.getLimit());

        LambdaQueryWrapper<AccountMoney> lqw = Wrappers.lambdaQuery(AccountMoney.class)
                .eq(AccountMoney::getUid, queryParams.getUid())
                .lt(queryParams.getStartTime() != null, AccountMoney::getCreateTime, queryParams.getStartTime())
                .gt(queryParams.getEndTime() != null, AccountMoney::getCreateTime, queryParams.getEndTime())
                .gt(queryParams.getStartAmount() != null, AccountMoney::getMoney, queryParams.getStartAmount())
                .lt(queryParams.getEndAmount() != null, AccountMoney::getMoney, queryParams.getEndAmount())
                .eq(queryParams.getSourceType() != null, AccountMoney::getSourceType, queryParams.getSourceType());
        if (queryParams.getIncome() != null) {
            lqw.in(AccountMoney::getSourceType, AccountMoneySourceType.show(queryParams.getIncome()));
        }

        page = accountMoneyDao.selectPage(page, lqw);
        return PagingData.<AccountMoneyDTO>builder()
                .page(page.getCurrent())
                .limit(page.getSize())
                .total(page.getTotal())
                .list(page.getRecords().stream().map(
                        item -> AccountMoneyDTO.builder()
                                .id(item.getId())
                                .createTime(item.getCreateTime())
                                .balance(item.getBalance())
                                .money(item.getMoney())
                                .sourceBody(item.getSourceBody())
                                .sourceId(item.getSourceId())
                                .sourceType(AccountMoneySourceType.show(item.getSourceType()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

}
