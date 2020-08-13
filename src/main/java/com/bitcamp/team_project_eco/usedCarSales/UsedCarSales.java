package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.usedCar.UsedCar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "used_car_sales")
public class UsedCarSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id") private Long reqId;
    @Column(name = "seller_seq") private int sellerSeq;
    @Column(name = "buyer_name") private String buyerName;
    @Column(name = "buyer_phone_number") private String buyerPhoneNumber;
    @Column(name = "buyer_email") private String buyerEmail;
    @Column(name = "buyer_addr") private String buyerAddr;

    @ManyToOne
    @JoinColumn(name = "usedcar_id")
    private UsedCar usedCar;
    public void setUsedCar(UsedCar usedCar){
        this.usedCar = usedCar;
    }

    @Builder
    public UsedCarSales(int sellerSeq,
                        String buyerName,
                        String buyerPhoneNumber,
                        String buyerEmail,
                        String buyerAddr,
                        UsedCar usedcarId){
        this.sellerSeq = sellerSeq;
        this.buyerName = buyerName;
        this.buyerPhoneNumber = buyerPhoneNumber;
        this.buyerEmail = buyerEmail;
        this.buyerAddr = buyerAddr;
        setUsedCar(usedcarId);
    }

    public UsedCarSales() {

    }
}
