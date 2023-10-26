package world.zmxl.demo.domain.account.model.valobj;

import lombok.Data;
import lombok.EqualsAndHashCode;
import world.zmxl.demo.types.request.PagingQuery;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryAccountMoneyVO extends PagingQuery {

    private Date startTime;

    private Date endTime;

    private Long uid;

    private Boolean income;

    private BigDecimal startAmount;

    private BigDecimal endAmount;

    private Integer sourceType;

}
