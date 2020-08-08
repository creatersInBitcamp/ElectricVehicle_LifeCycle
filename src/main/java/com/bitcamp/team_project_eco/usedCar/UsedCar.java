package com.bitcamp.team_project_eco.usedCar;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "used_car")
public class UsedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usedcar_id") private Long usedCarId;

    @Column(name = "price") private String price;

    @Column(name = "age") private String age;

    @Column(name = "mileage") private String mileage;

    @Builder
    public UsedCar(String price,
                   String age,
                   String mileage){
        this.price = price;
        this.age = age;
        this.mileage = mileage;
    }

}
