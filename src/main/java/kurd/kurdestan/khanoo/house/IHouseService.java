package kurd.kurdestan.khanoo.house;

import kurd.kurdestan.khanoo.commen.SearchCriteria;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IHouseService {

    House save(House house);
    House update(House house);
    void delete(Long id);
    List<House> getAll();
    House getById(Long id);
    Page<House> paging(Integer page, Integer size);

    Page<House> pagingByAgencyId(Long agencyId, Integer page, Integer size);
    Page<House> pagingByRegionId(Long regionId, Integer page, Integer size);
    List<House> search(List<SearchCriteria> searchCriteria);


}
