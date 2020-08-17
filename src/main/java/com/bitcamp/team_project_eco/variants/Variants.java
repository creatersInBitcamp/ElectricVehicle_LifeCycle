package com.bitcamp.team_project_eco.variants;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"electricCar"})
@Table(name = "variants")
public class Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variants_id") private Long variantsId;
    @Column(name = "color", nullable = false) private String color;
    @Column(name = "images", nullable = false) private String images;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eccar_id")
    private ElectricCar electricCar;
    public void setElectricCar(ElectricCar electricCar){
        this.electricCar = electricCar;
    }

    public Variants(){}

    @Builder
    public Variants(String color, String images,ElectricCar electricCar){
        this.color = color;
        this.images = images;
        setElectricCar(electricCar);
    }

}
