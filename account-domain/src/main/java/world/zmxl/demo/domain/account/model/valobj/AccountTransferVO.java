package world.zmxl.demo.domain.account.model.valobj;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/26
 */
@Data
public class AccountTransferVO {

    private Long uid;

    private Long targetUid;

    private BigDecimal amount;

    /* TODO */
    private Date expectedTimeOfReceipt;

}
