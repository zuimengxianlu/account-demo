package world.zmxl.demo.domain.account.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/27
 */
@Data
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = -5192514685714575732L;

    /**
     * 余额
     */
    @NotNull(message = "[余额]不能为空")
    private BigDecimal balance;
    /**
     * 用户编号
     */
    @NotNull(message = "[用户编号]不能为空")
    private Long uid;
    /**
     * 是否锁定
     */
    @NotNull(message = "[是否锁定]不能为空")
    private boolean locked;

}
