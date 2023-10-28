package world.zmxl.demo.types.exception;

import cn.hutool.core.util.StrUtil;

import java.io.Serial;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/28
 */
public class ApiException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8819624975372828460L;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String template, Object... params) {
        super(StrUtil.format(template, params));
    }
}
