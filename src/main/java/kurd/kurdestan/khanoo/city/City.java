package kurd.kurdestan.khanoo.city;

import kurd.kurdestan.khanoo.agency.Agency;
import kurd.kurdestan.khanoo.commen.BaseEntity;
import kurd.kurdestan.khanoo.house.House;
import kurd.kurdestan.khanoo.region.Region;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="Tbl_city")
@Data
@Audited
public class City extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Region> region;


}
