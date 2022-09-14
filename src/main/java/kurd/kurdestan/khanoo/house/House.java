package kurd.kurdestan.khanoo.house;


import kurd.kurdestan.khanoo.agency.Agency;
import kurd.kurdestan.khanoo.city.City;
import kurd.kurdestan.khanoo.commen.BaseEntity;
import kurd.kurdestan.khanoo.image.Image;
import kurd.kurdestan.khanoo.region.Region;
import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_house")
public class House extends BaseEntity {

    @NotNull
    @Column(name = "house_location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "metrazh")
    private Double metrazh;

    @NotNull
    @Column(name = "year")
    private Integer year;

    @NotNull
    @Column(name = "tabaghe")
    private Integer tabaghe;

    @Column(name = "room")
    private Integer room;

    @Column(name = "parking")
    private Boolean parking;

    @Column(name = "anbari")
    private Boolean anbari;

    @Column(name = "balcon")
    private Boolean balcon;

    @Column(name = "asansor")
    private Boolean asansor;

    @Column(name = "vahed")
    private Integer vahed;

    @NotNull
    @Column(name = "type_of_house")
    @Enumerated
    private TypeOfHouse TypeOfHouse;

    @NotNull
    @Column(name = "type")
    @Enumerated
    private Type type;

    @Column(name = "priceOfFrosh")
    private BigDecimal priceOfFrosh;

    @Column(name = "priceOfEjare")
    private BigDecimal priceOfEjare;

    @Column(name = "shomaliOfjnobi")
    private Boolean shomaliJnobi;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> imageList;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
