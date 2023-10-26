package world.zmxl.demo.types.response.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagingData<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 8030105124538349525L;

    private List<T> list;

    private long page = 1;

    private long total = 0;

    private long limit = 0;

}
