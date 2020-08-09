package com.bitcamp.team_project_eco.electriccar;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "electric_car")
@NamedQuery(name = "ElectricCar.findByCarId",
        query = "select e from ElectricCar e where  e.carId = :carId")
public class ElectricCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id") private Long id;

    @Column(name = "manufacturer", nullable = false) private String manufacturer;

    @Column(name = "trim", nullable = false) private String trim;

    @Column(name = "manufacturing_yyyy_mm", nullable = false) private String manufacturingYyyyMm;

    @Column(name = "price", nullable = false) private String price;

    @Column(name = "fuel_efficiency", nullable = false) private String fuelEfficiency;

    @Column(name = "rapid_charging", nullable = false) private String rapidCharging;

    @Column(name = "slow_charging", nullable = false) private String slowCharging;

    @Column(name = "mileage", nullable = false) private String mileage;

    @Column(name = "battery_capacity", nullable = false) private String batteryCapacity;

    @Column(name = "subsidy", nullable = false) private String subsidy;

    @Column(name = "production_site", nullable = false) private String productionSite;

    @Column(name = "color", nullable = false) private String color;

    @Column(name = "technical_option", nullable = false) private String technicalOption;

    @Column(name = "design_option", nullable = false) private String designOption;

    public ElectricCar() {}

    @Builder
    public ElectricCar(String manufacturer, String trim, String manufacturingYyyyMm,
                       String price, String fuelEfficiency, String rapidCharging,
                       String slowCharging, String mileage, String batteryCapacity,
                       String subsidy, String productionSite, String color, String technicalOption,
                       String designOption) {
        this.manufacturer = manufacturer;
        this.trim = trim;
        this. manufacturingYyyyMm = manufacturingYyyyMm;
        this.price = price;
        this.fuelEfficiency = fuelEfficiency;
        this.rapidCharging = rapidCharging;
        this.slowCharging = slowCharging;
        this.mileage = mileage;
        this.batteryCapacity = batteryCapacity;
        this.subsidy = subsidy;
        this.productionSite = productionSite;
        this.color = color;
        this.technicalOption = technicalOption;
        this.designOption = designOption;
    }

}
