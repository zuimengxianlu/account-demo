package world.zmxl.demo.domain.account.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import world.zmxl.demo.types.enm.AccountMoneySourceType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountMoneyDTO {

    private Long id;

    /**
     * 用户编号
     */
    @NotNull(message = "[用户编号]不能为空")
    private Long uid;

    /**
     * 金额
     */
    @NotNull(message = "[金额]不能为空")
    private BigDecimal money;

    /**
     * 余额
     */
    @NotNull(message = "[余额]不能为空")
    private BigDecimal balance;

    /**
     * 来源类型
     */
    @NotNull(message = "[来源类型]不能为空")
    private AccountMoneySourceType sourceType;

    /**
     * 来源主体内容
     */
    private String sourceBody;

    /**
     * 来源编号
     */
    private Long sourceId;

    private Date createTime;

}
