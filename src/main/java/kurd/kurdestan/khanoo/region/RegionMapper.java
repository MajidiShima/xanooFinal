package kurd.kurdestan.khanoo.region;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    Region toRegion(RegionDTO regionDTO);

    RegionDTO toRegionDTO(Region region);

    List<Region> toRegionList(List<RegionDTO> regionListDTO);

    List<RegionDTO> toRegionDTOs(List<Region> regionList);


}
