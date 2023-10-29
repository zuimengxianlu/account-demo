package world.zmxl.demo.app.handler;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import world.zmxl.demo.types.exception.ApiException;
import world.zmxl.demo.types.response.Result;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/28
 */
@Slf4j
@RestControllerAdvice(basePackages = "world.zmxl.demo.trigger.http")
public class DefaultExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public Result<String> apiExceptionHandler(ApiException e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public Result<String> NullPointerExceptionHandler(NullPointerException e) {
        return Result.error(StrUtil.isBlank(e.getMessage()) ? "服务器数据异常，请联系管理员!" : e.getMessage(), e);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> NullPointerExceptionHandler(Exception e) {
        return Result.error("服务器异常", e);
    }

}
