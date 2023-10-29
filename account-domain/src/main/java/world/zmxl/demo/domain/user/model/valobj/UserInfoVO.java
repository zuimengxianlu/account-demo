package world.zmxl.demo.domain.user.model.valobj;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/25
 */
@Data
public class UserInfoVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5650143115664771864L;

    private Long uid;

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
