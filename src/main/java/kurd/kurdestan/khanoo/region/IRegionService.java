package kurd.kurdestan.khanoo.region;

import java.util.List;

public interface IRegionService  {

    Region save(Region region);
    Region update(Region region);
    Region getById(Long id);
    List<Region>getAll();
    Region getByName(String name);
    List<Region> getAllByHouse_Id(Long houseId);
    List<Region> getAllByCity_Id(Long cityId);
}
