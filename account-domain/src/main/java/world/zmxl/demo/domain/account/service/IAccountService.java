package world.zmxl.demo.domain.account.service;

import world.zmxl.demo.domain.account.model.entity.AccountMoneyDTO;
import world.zmxl.demo.domain.account.model.valobj.AccountTransferVO;
import world.zmxl.demo.domain.account.model.valobj.QueryAccountMoneyVO;
import world.zmxl.demo.types.response.Result;
import world.zmxl.demo.types.response.data.PagingData;

import java.math.BigDecimal;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
public interface IAccountService {

    Result<BigDecimal> getAccount(Long uid);

    Result<PagingData<AccountMoneyDTO>> showAccountMoney(QueryAccountMoneyVO queryParams);

    Result<?> accountTransfer(AccountTransferVO accountTransferBody);

}
