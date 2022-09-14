package kurd.kurdestan.khanoo.commen;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data

public class PagingData<T> {

    private Integer totalPage;
    private Integer currentPage;
    private List<T> data;

}
