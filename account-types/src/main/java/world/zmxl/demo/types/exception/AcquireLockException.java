package world.zmxl.demo.types.exception;

import cn.hutool.core.util.StrUtil;

import java.io.Serial;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/27
 */
public class AcquireLockException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1618555117099057800L;

    public AcquireLockException(String lockKey) {
        super(StrUtil.format("lock : {}", lockKey));
    }
}
