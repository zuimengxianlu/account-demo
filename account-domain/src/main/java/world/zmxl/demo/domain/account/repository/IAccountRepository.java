package world.zmxl.demo.domain.account.repository;

import org.springframework.transaction.annotation.Transactional;
import world.zmxl.demo.domain.account.model.entity.Account;
import world.zmxl.demo.types.enm.AccountMoneySourceType;

import java.math.BigDecimal;

/**
 * 接口的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
public interface IAccountRepository {

    Account selectUserAccount(Long uid);

    @Transactional(rollbackFor = Exception.class)
    void updateBalance(Long uid, BigDecimal amount, AccountMoneySourceType accountMoneySourceType);
}
