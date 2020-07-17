package com.bitcamp.team_project_eco.newCar.comparison;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
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
}
