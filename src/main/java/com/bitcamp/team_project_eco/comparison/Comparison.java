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

    public Comparison(Long id, String manufacturer, String manufacturing_year, String price, String fuel_efficiency, String cc, String mile_age, String make, String picture, String order_id) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturing_year() {
        return manufacturing_year;
    }

    public void setManufacturing_year(String manufacturing_year) {
        this.manufacturing_year = manufacturing_year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFuel_efficiency() {
        return fuel_efficiency;
    }

    public void setFuel_efficiency(String fuel_efficiency) {
        this.fuel_efficiency = fuel_efficiency;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getMile_age() {
        return mile_age;
    }

    public void setMile_age(String mile_age) {
        this.mile_age = mile_age;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Comparison{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", manufacturing_year='" + manufacturing_year + '\'' +
                ", price='" + price + '\'' +
                ", fuel_efficiency='" + fuel_efficiency + '\'' +
                ", cc='" + cc + '\'' +
                ", mile_age='" + mile_age + '\'' +
                ", make='" + make + '\'' +
                ", picture='" + picture + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
