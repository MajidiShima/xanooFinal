package kurd.kurdestan.khanoo.region;


import kurd.kurdestan.khanoo.city.City;
import kurd.kurdestan.khanoo.commen.BaseEntity;
import kurd.kurdestan.khanoo.house.House;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_region")
@Data
@Audited

public class Region extends BaseEntity {

    @NotNull
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "region",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<House> house;


}
