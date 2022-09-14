package kurd.kurdestan.khanoo.agency;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.khanoo.house.House;
import kurd.kurdestan.khanoo.house.LocationDTO;
import kurd.kurdestan.khanoo.image.Image;
import kurd.kurdestan.khanoo.region.Region;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AgencyDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = false, hidden = true)
    private String title;

    @ApiModelProperty(required = false, hidden = true)
    private String phoneOrEmail;

    @ApiModelProperty(required = false, hidden = true)
    private Point<G2D> location;

    @ApiModelProperty(required = false, hidden = true)
    private String address;

    @ApiModelProperty(required = false, hidden = true)
    private List<House> houses;

    @ApiModelProperty(required = false, hidden = true)
    private Image image;

    @ApiModelProperty(required = false, hidden = true)
    private Region region;
}
