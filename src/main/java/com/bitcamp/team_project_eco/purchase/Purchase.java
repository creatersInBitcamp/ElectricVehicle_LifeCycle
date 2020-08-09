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
@ToString
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id",nullable = false) private Long id;
    @Column(name="purchasing_method",nullable = false) private String purchasingMethod;
    @Column(name="purchase_time",nullable = false) private String purchaseTime;
    @Column(name="purchase_amount",nullable = false) private String purchaseAmount ;
    @Column(name="purchase_price",nullable = false) private String purchasePrice ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eccar_id")
    private ElectricCar electricCar;

    public Purchase(){}

    public Purchase(String purchasingMethod, String purchaseTime,
                    String purchaseAmount, String purchasePrice) {
        this.purchasingMethod = purchasingMethod;
        this.purchaseTime = purchaseTime;
        this.purchaseAmount = purchaseAmount;
        this.purchasePrice = purchasePrice;
    }

}
