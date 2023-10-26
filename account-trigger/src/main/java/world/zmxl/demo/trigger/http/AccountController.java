package world.zmxl.demo.trigger.http;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import world.zmxl.demo.domain.account.model.valobj.AccountTransferVO;
import world.zmxl.demo.domain.account.model.valobj.QueryAccountMoneyVO;
import world.zmxl.demo.domain.account.service.IAccountService;
import world.zmxl.demo.types.response.Result;
import world.zmxl.demo.types.response.data.PagingData;

import java.math.BigDecimal;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@RestController
@RequestMapping("/api/account-demo")
public class AccountController {

    @Resource(type = IAccountService.class)
    private IAccountService accountService;

    @GetMapping("/v1/account")
    private Result<BigDecimal> getAccount(@RequestParam Long uid) {
        return accountService.getAccount(uid);
    }

    @GetMapping("/v1/account-money")
    private Result<PagingData<?>> showAccountMoney(QueryAccountMoneyVO queryParams) {
        return accountService.showAccountMoney(queryParams);
    }

    @PostMapping("/v1/account-transfer")
    private Result<?> accountTransfer(AccountTransferVO accountTransferBody) {
        return accountService.accountTransfer(accountTransferBody);
    }

}
