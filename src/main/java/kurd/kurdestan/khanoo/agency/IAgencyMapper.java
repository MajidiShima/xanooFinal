package kurd.kurdestan.khanoo.agency;

import kurd.kurdestan.khanoo.house.House;
import kurd.kurdestan.khanoo.house.HouseDTO;
import kurd.kurdestan.khanoo.house.LocationDTO;
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
public interface IAgencyMapper {
    @Mappings({
            @Mapping(source = "locationDTO", target = "location", qualifiedByName = "locationDtoToLocation")})
    Agency toAgency(AgencyDTO agencyDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", qualifiedByName = "locationToLocationDTO")})

    AgencyDTO toAgencyDTO(Agency agency);

    List<AgencyDTO> toAgencyDTS(AgencyDTO agencyDTO);
    List<Agency> toAgencyDTO(List<Agency> agencyList);
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
