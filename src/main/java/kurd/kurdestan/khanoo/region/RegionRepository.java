package kurd.kurdestan.khanoo.region;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region,Long>, JpaSpecificationExecutor<Region> {

    Region findByName(String name);
    List<Region> findAllByCity_Id(Long cityId);
    List<Region> findAllByHouse_Id(Long houseId);
    Page<Region> findAll(Pageable pageable);
    List<Region> findAll(Specification<Region> specification);


}
