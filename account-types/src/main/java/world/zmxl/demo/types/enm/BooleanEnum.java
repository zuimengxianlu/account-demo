package world.zmxl.demo.types.enm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 枚举的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/28
 */
@AllArgsConstructor
@Getter
public enum BooleanEnum {

    TRUE(true, "true", 1),

    FALSE(false, "false", 0);

    private final boolean val;

    private final String strVal;

    private final Integer numVal;

    public static boolean isTrue(Boolean val) {
        return Boolean.TRUE.equals(val);
    }

    public static boolean isTrue(String val) {
        return TRUE.strVal.equals(val.toLowerCase());
    }

    public static boolean isTrue(Integer val) {
        return TRUE.numVal.equals(val);
    }

}
