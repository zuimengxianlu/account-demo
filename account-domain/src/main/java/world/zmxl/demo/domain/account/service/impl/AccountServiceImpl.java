package world.zmxl.demo.domain.account.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import world.zmxl.demo.domain.account.repository.IAccountRepository;
import world.zmxl.demo.domain.account.service.IAccountService;

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

}
