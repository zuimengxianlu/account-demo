package world.zmxl.demo.infrastructure.repository;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import world.zmxl.demo.domain.account.repository.IAccountRepository;
import world.zmxl.demo.infrastructure.dao.IAccountDao;
import world.zmxl.demo.infrastructure.dao.IAccountMoneyDao;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Repository
public class AccountRepository implements IAccountRepository {

    @Resource(type = IAccountDao.class)
    private IAccountDao accountDao;

    @Resource(type = IAccountMoneyDao.class)
    private IAccountMoneyDao accountMoneyDao;

}
