package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.image.Image;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "used_car")
public class UsedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usedcar_id") private Long usedCarId;
    @Column(name = "price") private String price;
    @Column(name = "age") private String age;
    @Column(name = "mileage") private String mileage;
    @Column(name = "img_1") private String imgFirst;
    @Column(name = "img_2") private String imgSecond;
    @Column(name = "img_3") private String imgThird;
    @Column(name = "img_4") private String imgFourth;

    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "img_id")
    private Image image;

    public void setImage(Image image){
        this.image = image;
    }*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    public UsedCar() {

    }

    public void setUser(User user){
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eccar_id")
    private ElectricCar electricCar;

    public void setElectricCar(ElectricCar electricCar){
        this.electricCar = electricCar;
    }

    @Builder
    public UsedCar(String price,
                   String age,
                   String mileage,
                   String imgFirst,
                   String imgSecond,
                   String imgThird,
                   String imgFourth,
                   User userSeq,
                   ElectricCar eccarId){
        this.price = price;
        this.age = age;
        this.mileage = mileage;
        this.imgFirst = imgFirst;
        this.imgSecond = imgSecond;
        this.imgThird = imgThird;
        this.imgFourth = imgFourth;
        setUser(userSeq);
        setElectricCar(eccarId);
    }
}
