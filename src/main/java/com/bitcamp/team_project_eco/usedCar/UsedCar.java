package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.user.User;
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

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Builder
    public UsedCar(String price,
                   String age,
                   String mileage){
        this.price = price;
        this.age = age;
        this.mileage = mileage;
    }
}
