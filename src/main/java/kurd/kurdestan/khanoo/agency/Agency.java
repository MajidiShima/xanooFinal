package kurd.kurdestan.khanoo.agency;


import kurd.kurdestan.khanoo.city.City;
import kurd.kurdestan.khanoo.commen.BaseEntity;
import kurd.kurdestan.khanoo.house.House;
import kurd.kurdestan.khanoo.image.Image;
import kurd.kurdestan.khanoo.region.Region;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_agency")
@Audited
@Data
public class Agency extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "phoneOrEmail")
    private String phoneOrEmail;

    @NotNull
    @Column(name = "agency_location")
    private Point<G2D> location;

    @NotNull
    @Column(name="Address")
    private String address;

    @OneToMany(mappedBy = "Agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;


    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
