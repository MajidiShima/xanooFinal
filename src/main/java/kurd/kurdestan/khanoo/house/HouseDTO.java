package kurd.kurdestan.khanoo.house;


import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.khanoo.agency.Agency;
import kurd.kurdestan.khanoo.city.City;
import kurd.kurdestan.khanoo.commen.BaseDTO;
import kurd.kurdestan.khanoo.image.Image;
import kurd.kurdestan.khanoo.region.Region;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HouseDTO extends BaseDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true, hidden = false)
    private Double metrazh;

    @ApiModelProperty(required = true, hidden = false)
    private Integer year;

    @ApiModelProperty(required = true, hidden = false)
    private Integer tabaghe;

    @ApiModelProperty(required = true, hidden = false)
    private Integer room;
    @ApiModelProperty(required = true, hidden = false)
    private Boolean parking;

    @ApiModelProperty(required = true, hidden = false)
    private Boolean anbari;

    @ApiModelProperty(required = true, hidden = false)
    private Boolean balcon;
    @ApiModelProperty(required = true, hidden = false)
    private Boolean asansor;

    @ApiModelProperty(required = true, hidden = false)
    private Integer vahed;

    @ApiModelProperty(required = true, hidden = false)
    private TypeOfHouse TypeOfHouse;

    @ApiModelProperty(required = true, hidden = false)
    private Type type;

    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal priceOfFrosh;

    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal priceOfEjare;

    @ApiModelProperty(required = true, hidden = false)
    private Boolean shomaliJnobi;

    @ApiModelProperty(required = true,hidden = false)
    private List<Image> imageList;

    @ApiModelProperty(required = true,hidden = false)
    private Agency agency;

    @ApiModelProperty(required = true,hidden = false)
    private Region region;

}
