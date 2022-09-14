package kurd.kurdestan.khanoo.commen;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;

}
