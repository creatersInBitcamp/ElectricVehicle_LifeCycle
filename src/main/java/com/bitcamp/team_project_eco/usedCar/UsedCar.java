package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.image.Image;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "img_id")
    private Image image;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eccar_id")
    private ElectricCar electricCar;

    @Builder
    public UsedCar(String price,
                   String age,
                   String mileage,
                   Long imgId,
                   User userSeq,
                   ElectricCar eccarId){
        this.price = price;
        this.age = age;
        this.mileage = mileage;
        (this.image = new Image().setImageId(imgId)).getImageId();
        (this.user = userSeq).getUserSeq();
        (this.electricCar = eccarId).getEccarId();
    }
}
