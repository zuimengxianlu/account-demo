package world.zmxl.demo.infrastructure.repository;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import world.zmxl.demo.domain.user.model.entity.UserInfo;
import world.zmxl.demo.domain.user.repository.IUserRepository;
import world.zmxl.demo.infrastructure.dao.IUserDao;
import world.zmxl.demo.infrastructure.entity.User;

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

    @Override
    public UserInfo selectUserInfo(Long uid) {
        User user = userDao.selectById(uid);
        return user == null ? null : UserInfo.builder()
                .uid(uid)
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
