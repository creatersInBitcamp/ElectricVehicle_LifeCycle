package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.usedCarSales.UsedCarSales;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = {"user","electricCar","usedCarSalesList"})
@Table(name = "used_car")
public class UsedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usedcar_id") private Long usedCarId;
    @Column(name = "price") private String price;
    @Column(name = "age") private String age;
    @Column(name = "mileage") private String mileage;

    @Convert(converter = AdditionalDataConverter.class)
    private Img img;
    public void setImg(Img img){
        this.img = img;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

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

    @OneToMany(mappedBy = "usedCar", cascade = CascadeType.ALL)
    private List<UsedCarSales> usedCarSalesList = new ArrayList<>();

    public UsedCar(){}

    @Builder
    public UsedCar(String price,
                   String age,
                   String mileage,
                   String imgId1,
                   String imgId2,
                   String imgId3,
                   String imgId4,
                   User userSeq,
                   ElectricCar eccarId,
                   List<UsedCarSales> usedCarSalesList) {
        this.price = price;
        this.age = age;
        this.mileage = mileage;
        Img image = new Img();
        image.setImg1(imgId1);
        image.setImg2(imgId2);
        image.setImg3(imgId3);
        image.setImg4(imgId4);
        setImg(image);
        setUser(userSeq);
        setElectricCar(eccarId);
        this.usedCarSalesList.addAll(usedCarSalesList);
    }
}
