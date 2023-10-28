package world.zmxl.demo.types.enm;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

    public static final Map<Boolean, Collection<AccountMoneySourceType>> SOURCE_TYPE_GROUP_REVENUE = new HashMap<>();

    public static final Map<Integer, AccountMoneySourceType> SOURCE_TYPE_GROUP_KEY = new HashMap<>();

    static {
        for (AccountMoneySourceType type : values()) {
            if (type.income) {
                Collection<AccountMoneySourceType> tmp = SOURCE_TYPE_GROUP_REVENUE.getOrDefault(Boolean.TRUE, new LinkedList<>());
                tmp.add(type);
                SOURCE_TYPE_GROUP_REVENUE.put(Boolean.TRUE, tmp);
            }
            else {
                Collection<AccountMoneySourceType> tmp = SOURCE_TYPE_GROUP_REVENUE.getOrDefault(Boolean.FALSE, new LinkedList<>());
                tmp.add(type);
                SOURCE_TYPE_GROUP_REVENUE.put(Boolean.TRUE, tmp);
            }
            SOURCE_TYPE_GROUP_KEY.put(type.getKey(), type);
        }
    }

    public static Collection<AccountMoneySourceType> show(boolean income) {
        return SOURCE_TYPE_GROUP_REVENUE.get(income);
    }

    public static AccountMoneySourceType show(int key) {
        return SOURCE_TYPE_GROUP_KEY.get(key);
    }

}
