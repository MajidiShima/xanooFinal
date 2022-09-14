package kurd.kurdestan.khanoo.house;


import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IHouseMapper {

    @Mappings({
            @Mapping(source = "locationDTO", target = "location", qualifiedByName = "locationDtoToLocation")})


    @Mappings({
            @Mapping(source = "location", target = "locationDTO", qualifiedByName = "locationToLocationDTO")})
    House toHouse(HouseDTO houseDTO);

    HouseDTO toHouseDTO(House house);

    List<HouseDTO> toHouseTDOs(List<House> houseList);

    List<House> toHouseList(List<HouseDTO> houseDTOList);

    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO) {
        Point<G2D> candidPoint = Geometries.mkPoint(new G2D(locationDTO.getLang(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
        return candidPoint;
    }

    @Named("locationToLocationDTO")
    default LocationDTO convertLocationToLocationDTO(Point<G2D> point) {
        G2D g2D = point.getPosition();
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLang(g2D.getLon());
        return locationDTO;
    }

}
