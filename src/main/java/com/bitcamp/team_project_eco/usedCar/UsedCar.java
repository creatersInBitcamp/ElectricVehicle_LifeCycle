package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.usedCarSales.UsedCarSales;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Column(name = "sale") private boolean sale;
    @Column(name = "main") private boolean main;
    @Column(name = "picture1") private String picture1;
    @Column(name = "picture2") private String picture2;
    @Column(name = "picture3") private String picture3;
    @Column(name = "picture4") private String picture4;
    @Column(name = "picture5") private String picture5;
    @Column(name = "picture6") private String picture6;
    @Column(name = "picture7") private String picture7;
    @Column(name = "picture8") private String picture8;
    @Column(name = "picture9") private String picture9;
    @Column(name = "picture10") private String picture10;
    @Column(name = "picture11") private String picture11;

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
                   boolean sale,
                   boolean main,
                   String imgId1,
                   String imgId2,
                   String imgId3,
                   String imgId4,
                   User userSeq,
                   ElectricCar eccarId,
                   String picture5,String picture6,String picture7,String picture8,
                   String picture9,String picture10,String picture11,
                   List<UsedCarSales> usedCarSalesList) {
        this.price = price;
        this.age = age;
        this.mileage = mileage;
        this.sale = sale;
        this.main = main;
        this.picture1 = imgId1;
        this.picture2 = imgId2;
        this.picture3 = imgId3;
        this.picture4 = imgId4;
        this.picture5 = picture5;
        this.picture6 = picture6;
        this.picture7 = picture7;
        this.picture8 = picture8;
        this.picture9 = picture9;
        this.picture10 = picture10;
        this.picture11 = picture11;
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
