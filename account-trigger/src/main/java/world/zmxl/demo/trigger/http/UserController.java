package world.zmxl.demo.trigger.http;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.zmxl.demo.domain.user.model.valobj.UserInfoVO;
import world.zmxl.demo.domain.user.service.IUserService;
import world.zmxl.demo.types.response.Result;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@RestController
@RequestMapping("/api/account-demo")
public class UserController {

    @Resource(type = IUserService.class)
    private IUserService userService;

    @GetMapping("/v1/user")
    public Result<UserInfoVO> getUserInfo(@RequestParam("uid") Long uid) {
        return Result.success(userService.getUserInfo(uid));
    }

}
