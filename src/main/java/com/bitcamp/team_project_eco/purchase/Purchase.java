package com.bitcamp.team_project_eco.purchase;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = {"user","electricCar"})
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id",nullable = false) private Long orderId;
    @Column(name="purchasing_method",nullable = false) private String purchasingMethod;
    @Column(name="purchase_time",nullable = false) private String purchaseTime;
    @Column(name="purchase_price",nullable = false) private String purchasePrice;
    @Column(name="color",nullable = false) private String color;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;
    public void setUser(User user){
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "eccar_id")
    private ElectricCar electricCar;
    public void setElectricCar(ElectricCar electricCar){
        this.electricCar = electricCar;
    }

    public Purchase(){}

    public Purchase(String purchasingMethod, String purchaseTime,
                    String purchasePrice, String color, User user, ElectricCar electricCar) {
        this.purchasingMethod = purchasingMethod;
        this.purchaseTime = purchaseTime;
        this.purchasePrice = purchasePrice;
        this.color = color;
        setUser(user);
        setElectricCar(electricCar);
    }

}
