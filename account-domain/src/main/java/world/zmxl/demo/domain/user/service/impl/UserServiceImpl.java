package world.zmxl.demo.domain.user.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import world.zmxl.demo.domain.user.model.entity.UserInfo;
import world.zmxl.demo.domain.user.model.valobj.UserInfoVO;
import world.zmxl.demo.domain.user.repository.IUserRepository;
import world.zmxl.demo.domain.user.service.IUserService;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource(type = IUserRepository.class)
    private IUserRepository userRepository;

    @Override
    public UserInfoVO getUserInfo(Long uid) {
        UserInfo userInfo = userRepository.selectUserInfo(uid);
        UserInfoVO userInfoVO = new UserInfoVO();
        // TODO entity to vo
        return userInfoVO;
    }
}
