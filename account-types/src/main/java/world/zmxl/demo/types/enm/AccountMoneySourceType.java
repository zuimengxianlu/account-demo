package world.zmxl.demo.types.enm;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/27
 */
@AllArgsConstructor
@Getter
public enum AccountMoneySourceType {

    TRANSFER_OUT(20, "系统内转出", false),

    TRANSFER_IN(21, "系统内转入", true),

    ;

    @EnumValue
    private final Integer key;

    private final String sourceBody;

    private final boolean income;

}
