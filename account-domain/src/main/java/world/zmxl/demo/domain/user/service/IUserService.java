package world.zmxl.demo.domain.user.service;

import world.zmxl.demo.domain.user.model.valobj.UserInfoVO;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
public interface IUserService {

    UserInfoVO getUserInfo(Long uid);

}
