package world.zmxl.demo.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import world.zmxl.demo.infrastructure.entity.AccountItem;

/**
 * 接口的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@Mapper
public interface IAccountItemDao extends BaseMapper<AccountItem> {
}
