package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public UsedCar(Long usedCarId, String price, String age, String mileage, User user) {
        this.usedCarId = usedCarId;
        this.price = price;
        this.age = age;
        this.mileage = mileage;
        this.user = user;
    }

    public Long getUsedCarId() {
        return usedCarId;
    }

    public void setUsedCarId(Long usedCarId) {
        this.usedCarId = usedCarId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UsedCar{" +
                "usedCarId=" + usedCarId +
                ", price='" + price + '\'' +
                ", age='" + age + '\'' +
                ", mileage='" + mileage + '\'' +
                ", user=" + user +
                '}';
    }
}
