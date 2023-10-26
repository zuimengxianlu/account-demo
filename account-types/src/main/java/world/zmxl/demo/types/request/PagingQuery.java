package world.zmxl.demo.types.request;

import lombok.Data;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/26
 */
@Data
public class PagingQuery {

    private long page = 1;

    private long limit = 1;

}
