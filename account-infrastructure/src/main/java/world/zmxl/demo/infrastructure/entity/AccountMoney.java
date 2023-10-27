package world.zmxl.demo.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import world.zmxl.demo.types.entity.BaseEntity;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@TableName(value = "account_money")
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountMoney extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -3003477620288854793L;

    /**
     * 用户编号
     */
    @NotNull(message = "[用户编号]不能为空")
    private Long uid;

    /**
     * 金额
     */
    @NotNull(message = "[金额]不能为空")
    private Integer money;

    /**
     * 余额
     */
    @NotNull(message = "[余额]不能为空")
    private BigDecimal balance;

    /**
     * 来源类型
     */
    @NotNull(message = "[来源类型]不能为空")
    private Integer sourceType;
    /**
     * 来源主体内容
     */
    private String sourceBody;
    /**
     * 来源编号
     */
    private Long sourceId;

}
