package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter @Setter @ToString(exclude = {"usedCar"})
@Table(name = "used_car_sales")
public class UsedCarSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id") private Long reqId;
    @Column(name = "buyer_name") private String buyerName;
    @Column(name = "buyer_phone_number") private String buyerPhoneNumber;
    @Column(name = "buyer_email") private String buyerEmail;
    @Column(name = "buyer_addr") private String buyerAddr;
    @Column(name = "car_name") private String carName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usedcar_id")
    private UsedCar usedCar;
    public void setUsedCar(UsedCar usedCar){
        this.usedCar = usedCar;
    }

    @Builder
    public UsedCarSales(String buyerName,
                        String buyerPhoneNumber,
                        String buyerEmail,
                        String buyerAddr,
                        String carName,
                        UsedCar usedCarId){
        this.buyerName = buyerName;
        this.buyerPhoneNumber = buyerPhoneNumber;
        this.buyerEmail = buyerEmail;
        this.buyerAddr = buyerAddr;
        this.carName = carName;
        setUsedCar(usedCarId);
    }

    public UsedCarSales() {

    }
}
