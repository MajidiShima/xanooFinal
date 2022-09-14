package kurd.kurdestan.khanoo.city;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.khanoo.commen.BaseDTO;
import kurd.kurdestan.khanoo.region.Region;
import lombok.Data;

import java.util.List;

@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private List<Region> region;


}
