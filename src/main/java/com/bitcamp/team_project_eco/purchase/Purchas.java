package com.bitcamp.team_project_eco.purchase;

import javax.persistence.*;

@Entity
@Table(name="purchase")
public class Purchas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id",nullable = false) private Long id;
    @Column(name="purchasing_method",nullable = false) private String purchasing_method;
    @Column(name="purchase_time",nullable = false) private String purchase_time;
    @Column(name="purchase_amount",nullable = false) private String purchase_amount ;

    public Purchas(Long id, String purchasing_method, String purchase_time, String purchase_amount) {
        this.id = id;
        this.purchasing_method = purchasing_method;
        this.purchase_time = purchase_time;
        this.purchase_amount = purchase_amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchasing_method() {
        return purchasing_method;
    }

    public void setPurchasing_method(String purchasing_method) {
        this.purchasing_method = purchasing_method;
    }

    public String getPurchase_time() {
        return purchase_time;
    }

    public void setPurchase_time(String purchase_time) {
        this.purchase_time = purchase_time;
    }

    public String getPurchase_amount() {
        return purchase_amount;
    }

    public void setPurchase_amount(String purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    @Override
    public String toString() {
        return "Purchas{" +
                "id=" + id +
                ", purchasing_method='" + purchasing_method + '\'' +
                ", purchase_time='" + purchase_time + '\'' +
                ", purchase_amount='" + purchase_amount + '\'' +
                '}';
    }

}
