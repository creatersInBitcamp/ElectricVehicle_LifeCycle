package com.bitcamp.team_project_eco.newCar.insurance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insurance_product",nullable = false) private Long id;
    @Column(name="carprice",nullable = false) private String carprice;
    @Column(name="residential_area",nullable = false) private String residential_area;
    @Column(name="sortation",nullable = false) private String sortation ;
    @Column(name="fuel_efficiency",nullable = false) private String fuel_efficiency ;
    @Column(name="acquisition_tax",nullable = false) private String acquisition_tax ;
    @Column(name="public_bond",nullable = false) private String public_bond;
    @Column(name="purchase_rate",nullable = false) private String purchase_rate;
    @Column(name="rate_discount",nullable = false) private String rate_discount;
    @Column(name="discount_public_bonds",nullable = false) private String discount_public_bonds;
    @Column(name="additional_amount",nullable = false) private String additional_amount;
    @Column(name="order_id",nullable = false) private String order_id;

}
