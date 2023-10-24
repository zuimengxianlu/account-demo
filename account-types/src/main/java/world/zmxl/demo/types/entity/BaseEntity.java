package world.zmxl.demo.types.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Getter
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Getter
    @Setter
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @Getter
    @Setter
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntity that)) {
            return false;
        }

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
