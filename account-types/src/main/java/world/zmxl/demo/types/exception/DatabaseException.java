package world.zmxl.demo.types.exception;

import cn.hutool.core.util.StrUtil;

import java.io.Serial;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/28
 */
public class DatabaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2158388752387021967L;

    private DatabaseException(String prefix, String message) {
        super(prefix + ERROR +  message);
    }

    private static final String ERROR = " error : ";
    private static final String INSERT = "insert";
    private static final String UPDATE = "update";
    private static final String DELETED = "del";

    public static DatabaseException insertError(String message) {
        return new DatabaseException(INSERT, message);
    }

    public static DatabaseException insertError(String template, Object... params) {
        return new DatabaseException(INSERT, StrUtil.format(template, params));
    }

    public static DatabaseException updateError(String message) {
        return new DatabaseException(UPDATE, message);
    }

    public static DatabaseException updateError(String template, Object... params) {
        return new DatabaseException(UPDATE, StrUtil.format(template, params));
    }

    public static DatabaseException delError(String message) {
        return new DatabaseException(DELETED, message);
    }

    public static DatabaseException delError(String template, Object... params) {
        return new DatabaseException(DELETED, StrUtil.format(template, params));
    }

}
