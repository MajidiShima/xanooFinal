package kurd.kurdestan.khanoo.image;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.khanoo.commen.BaseEntity;
import kurd.kurdestan.khanoo.house.House;
import lombok.Data;


@Data
public class ImageDTO extends BaseEntity {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private House house;

}
