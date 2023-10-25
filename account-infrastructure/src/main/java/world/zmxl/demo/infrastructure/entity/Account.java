package world.zmxl.demo.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import world.zmxl.demo.types.entity.BaseEntity;

import java.io.Serial;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@TableName(value = "account")
@Data
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -6210123120550908935L;

    /**
     * 余额
     */
    @NotNull(message = "[余额]不能为空")
    private Integer balance;
    /**
     * 用户编号
     */
    @NotNull(message = "[用户编号]不能为空")
    private Long uid;
    /**
     * 是否锁定
     */
    @NotNull(message = "[是否锁定]不能为空")
    private Integer isLocked;

}
