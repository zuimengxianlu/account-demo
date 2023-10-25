package world.zmxl.demo.infrastructure.repository;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import world.zmxl.demo.domain.user.repository.IUserRepository;
import world.zmxl.demo.infrastructure.dao.IUserDao;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Repository
public class UserRepository implements IUserRepository {

    @Resource(type = IUserDao.class)
    private IUserDao userDao;

}
