package kurd.kurdestan.khanoo.house;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> ,
        JpaSpecificationExecutor<House> {

    @Query("select house from House house where distance(house.location, ?1) <?")
    List<House> findAllWithDistance(Point<G2D> refPnt, double dist);

    @Query("select house,distance(house.location, ?1) as distance from House  house order by distance")
    List<Tuple> findNearest(Point<G2D> refPnt);

    Page<House> findAllByRegion_Id(Long regionId, PageRequest pageable);
    Page<House> findAllByAgency_Id(Long agencyId, PageRequest pageable);
    Page<House> findAll(Pageable pageable);
    List<House> findAll(Specification<House> specification);



}
