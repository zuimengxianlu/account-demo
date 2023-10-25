package world.zmxl.demo.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import world.zmxl.demo.types.entity.BaseEntity;

import java.io.Serial;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@TableName(value = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 5051191412811482393L;

    /**
     * 用户昵称
     */
    @NotBlank(message = "[]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @Length(max = 255, message = "编码长度不能超过255")
    private String name;

    /**
     * 手机号
     */
    @Size(max = 11, message = "编码长度不能超过11")
    @Length(max = 11, message = "编码长度不能超过11")
    private String phone;

    /**
     * 密码
     */
    @NotBlank(message = "[密码]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @Length(max = 255, message = "编码长度不能超过255")
    private String password;

    /**
     * 邮箱
     */
    @Size(max = 255, message = "编码长度不能超过255")
    @Length(max = 255, message = "编码长度不能超过255")
    private String email;

}
