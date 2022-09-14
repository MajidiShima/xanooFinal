package kurd.kurdestan.khanoo.city;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toCity(CityDTO cityDTO);
    CityDTO toCityDTO(City city);
    List<City> toListCity(List<CityDTO> cityDTOList);
    List<CityDTO> toListDTO(List<City> cityList);
}
