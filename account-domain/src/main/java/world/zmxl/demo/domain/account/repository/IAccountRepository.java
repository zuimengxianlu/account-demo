package world.zmxl.demo.domain.account.repository;

import org.springframework.transaction.annotation.Transactional;
import world.zmxl.demo.domain.account.model.entity.AccountDTO;
import world.zmxl.demo.domain.account.model.entity.AccountMoneyDTO;
import world.zmxl.demo.domain.account.model.entity.UpdateAccountDTO;
import world.zmxl.demo.domain.account.model.valobj.QueryAccountMoneyVO;
import world.zmxl.demo.types.response.data.PagingData;

/**
 * 接口的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
public interface IAccountRepository {

    AccountDTO selectUserAccount(Long uid);

    @Transactional(rollbackFor = Exception.class)
    void updateBalance(UpdateAccountDTO dto);

    PagingData<AccountMoneyDTO> selectUserAccountMoney(QueryAccountMoneyVO queryParams);

}
