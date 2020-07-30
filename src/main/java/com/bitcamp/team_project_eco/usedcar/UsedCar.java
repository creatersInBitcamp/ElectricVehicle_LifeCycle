package com.bitcamp.team_project_eco.usedcar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "used_car")
public class UsedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usedcar_id") private Long id;

    @Column(name = "trim") private String trim;

    @Column(name = "age") private String age;

    @Column(name = "mileage") private String mileage;

    @Column(name = "price") private String price;

    @Column(name = "region") private String region;

    @Column(name = "img_id") private String imgId;

//    @OneToMany(mappedBy = "used_car", cascade = CascadeType.ALL)
//    user
//    @OneToMany(mappedBy = "used_car", cascade = CascadeType.ALL)
//    car


}
