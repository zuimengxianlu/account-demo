package world.zmxl.demo.types.response.data;

import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/26
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagingData<T> implements IPage<T>, Serializable {

    @Serial
    private static final long serialVersionUID = 8030105124538349525L;

    @Getter
    private List<T> list;

    private long page = 1;

    private long total = 0;

    private long limit = 0;

    private boolean searchCount = true;

    @Override
    public List<OrderItem> orders() {
        return null;
    }

    @Override
    public List<T> getRecords() {
        return this.list;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        this.list = Optional.ofNullable(records).orElse(ListUtil.empty());
        return this;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public IPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return limit;
    }

    @Override
    public IPage<T> setSize(long size) {
        limit = size < 0 ? 0 : size;
        return this;
    }

    @Override
    public long getCurrent() {
        return page;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        page = current < 1 ? 1 : current;
        return this;
    }

    @Override
    public boolean searchCount() {
        return this.searchCount;
    }


}
