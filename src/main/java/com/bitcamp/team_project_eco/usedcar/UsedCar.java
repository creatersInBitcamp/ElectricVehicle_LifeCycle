package com.bitcamp.team_project_eco.usedcar;

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

    @Column(name = "img_id") private String imgId;

    @Column(name = "manufacturer") private String manufacturer;

    @Column(name = "car_name") private String carName;

    @Column(name = "trim") private String trim;

    @Column(name = "age") private String age;

    @Column(name = "mileage") private String mileage;

//    @OneToMany(mappedBy = "used_car", cascade = CascadeType.ALL)
//    user
//    @OneToMany(mappedBy = "used_car", cascade = CascadeType.ALL)
//    car

    @Builder
    public UsedCar(String price,
                   String imgId,
                   String manufacturer,
                   String carName,
                   String trim,
                   String age,
                   String mileage){
        this.price = price;
        this.imgId = imgId;
        this.manufacturer = manufacturer;
        this.carName = carName;
        this.trim = trim;
        this.age = age;
        this.mileage = mileage;
    }
}
