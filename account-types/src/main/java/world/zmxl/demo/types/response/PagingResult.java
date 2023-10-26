package world.zmxl.demo.types.response;

import lombok.NoArgsConstructor;
import world.zmxl.demo.types.response.data.PagingData;

import java.io.Serial;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/26
 */
@NoArgsConstructor
public class PagingResult<T> extends Result<PagingData<T>>  {

    @Serial
    private static final long serialVersionUID = 2845081876360915806L;

    public static <T> Result<PagingData<T>> pagingSuccess() {
        return Result.success(new PagingData<T>());
    }

    public static <T> Result<PagingData<T>> pagingSuccess(List<T> list) {
        List<T> finalList = Optional.ofNullable(list).orElse(Collections.emptyList());
        return Result.success(PagingData.<T>builder().list(finalList).total(finalList.size()).build());
    }

    public static <T> Result<PagingData<T>> pagingSuccess(List<T> list, long page, long total, long limit) {
        List<T> finalList = Optional.ofNullable(list).orElse(Collections.emptyList());
        return Result.success(PagingData.<T>builder().list(finalList).total(total).page(page).limit(limit).build());
    }

}
