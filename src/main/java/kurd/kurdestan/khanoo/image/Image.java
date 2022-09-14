package kurd.kurdestan.khanoo.image;


import kurd.kurdestan.khanoo.city.City;
import kurd.kurdestan.khanoo.commen.BaseEntity;
import kurd.kurdestan.khanoo.house.House;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Audited
@Table(name = "Tbl_image")
public class Image extends BaseEntity {

    @NotNull
    @Column(name="name")
    private String name;


    @ManyToOne
    @JoinColumn(name="house_id")
    private House house;


}
