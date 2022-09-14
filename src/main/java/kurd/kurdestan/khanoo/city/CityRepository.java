package kurd.kurdestan.khanoo.city;

import kurd.kurdestan.khanoo.region.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CityRepository extends PagingAndSortingRepository<City,Long>, JpaSpecificationExecutor<Region> {

    List<City> findAllByName(String name);
    Page<City> findAll(Pageable pageable);

}
