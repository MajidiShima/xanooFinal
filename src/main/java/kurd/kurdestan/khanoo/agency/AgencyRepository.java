package kurd.kurdestan.khanoo.agency;

import kurd.kurdestan.khanoo.house.House;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface AgencyRepository extends PagingAndSortingRepository<Agency, Long> {


    @Query("select house from House house where distance(house.location, ?1) <?")
    List<House> findAllWithDistance(Point<G2D> refPnt, double dist);

    @Query("select house,distance(house.location, ?1) as distance from House  house order by distance")
    List<Tuple> findNearest(Point<G2D> refPnt);

    List<House> findAgenciesById(Long agencyId);


}
