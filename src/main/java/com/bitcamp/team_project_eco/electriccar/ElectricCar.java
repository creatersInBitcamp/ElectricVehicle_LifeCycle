package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.marketPrice.MarketPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "electric_car")
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


}
