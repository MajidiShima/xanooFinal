package kurd.kurdestan.khanoo.region;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.khanoo.city.City;
import kurd.kurdestan.khanoo.commen.BaseDTO;
import kurd.kurdestan.khanoo.house.House;
import lombok.Data;

import javax.persistence.SecondaryTable;
import java.util.List;

@Data

public class RegionDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private City city;

    @ApiModelProperty(required = false, hidden = true)
    private List<House> houses;

}
