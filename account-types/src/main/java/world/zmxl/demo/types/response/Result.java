package world.zmxl.demo.types.response;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.Serial;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1595321021075146012L;

    private Integer code = 200;

    private String msg;

    private T data;

    private List<String> errorMsgStack;

    public boolean isSuccess() {
        return code == 200;
    }

    public static <T> Result<T> success() {
        return Result.<T>builder().code(200).msg("访问成功").build();
    }

    public static <T> Result<T> success(String msg) {
        return Result.<T>builder().code(200).msg(msg).build();
    }

    public static <T> Result<T> success(T data) {
        return Result.<T>builder().code(200).msg("访问成功").data(data).build();
    }

    public static <T> Result<T> error(String msg) {
        return Result.<T>builder().code(400).msg(msg).build();
    }

    public static <T> Result<T> error(String template, Object... params) {
        return Result.<T>builder().code(400).msg(StrUtil.format(template, params)).build();
    }

    public static <T> Result<T> error(String msg, Throwable e) {
        final List<String> errorMsgStack = new ArrayList<>(32);
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        final String linebreak = System.lineSeparator();
        final StringTokenizer frames = new StringTokenizer(sw.getBuffer().toString(), linebreak);
        while (frames.hasMoreTokens()) {
            errorMsgStack.add(frames.nextToken());
        }
        return Result.<T>builder().code(400).msg(msg).errorMsgStack(errorMsgStack).build();
    }

}
