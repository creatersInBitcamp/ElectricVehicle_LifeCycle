package com.bitcamp.team_project_eco.comparison;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="comparison")
public class Comparison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id",nullable = false) private Long id;
    @Column(name="manufacturer",nullable = false) private String manufacturer;
    @Column(name="manufacturing_year",nullable = false) private String manufacturing_year ;
    @Column(name="price",nullable = false) private String price  ;
    @Column(name="fuel_efficiency",nullable = false) private String fuel_efficiency;
    @Column(name="cc",nullable = false) private String cc;
    @Column(name="mileage",nullable = false) private String mile_age;
    @Column(name="make",nullable = false) private String make;
    @Column(name="picture",nullable = false) private String picture ;
    @Column(name="order_id",nullable = false) private String order_id;

    public Comparison(){ }

    public Comparison(Long id,
                      String manufacturer,
                      String manufacturing_year,
                      String price,
                      String fuel_efficiency,
                      String cc,
                      String mile_age,
                      String make,
                      String picture,
                      String order_id){
        this.id = id;
        this.manufacturer = manufacturer;
        this.manufacturing_year = manufacturing_year;
        this.price = price;
        this.fuel_efficiency = fuel_efficiency;
        this.cc = cc;
        this.mile_age = mile_age;
        this.make = make;
        this.picture = picture;
        this.order_id = order_id;
    }
}
