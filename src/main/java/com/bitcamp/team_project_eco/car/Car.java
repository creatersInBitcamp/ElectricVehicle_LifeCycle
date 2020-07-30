package com.bitcamp.team_project_eco.car;


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
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="carId",nullable = false) private Long carId;
    @Column(name="carName",nullable = false) private String carName;
    @Column(name="employee",nullable = false) private String price ;
    @Column(name="engineType",nullable = false) private String engineType  ;
    @Column(name="superchargeMethod",nullable = false) private String superchargeMethod;
    @Column(name="exhaustVolume",nullable = false) private String exhaustVolume;
    @Column(name="fuel",nullable = false) private String fuel;
    @Column(name="fuelEfficiency",nullable = false) private String fuelEfficiency;
    @Column(name="passengersNumber",nullable = false) private String passengersNumber ;
    @Column(name="drivingMethod",nullable = false) private String drivingMethod;
    @Column(name="transmission",nullable = false) private String transmission;
    @Column(name="maximumOutput",nullable = false) private String maximumOutput ;
    @Column(name="maximumTorque",nullable = false) private String maximumTorque;
    @Column(name="topSpeed",nullable = false) private String topSpeed;
    @Column(name="accelerationPerformance",nullable = false) private String accelerationPerformance ;
    @Column(name="brakingPerformance",nullable = false) private String brakingPerformance;
    @Column(name="CO2Emissions",nullable = false) private String CO2Emissions;
    @Column(name="length",nullable = false) private String length ;
    @Column(name="fullWidth",nullable = false) private String fullWidth;
    @Column(name="height",nullable = false) private String height;
    @Column(name="wheelBase",nullable = false) private String wheelBase ;
    @Column(name="frontDistance",nullable = false) private String frontDistance;
    @Column(name="backDistance",nullable = false) private String backDistance;
    @Column(name="weight",nullable = false) private String weight;
    @Column(name="frontWheel",nullable = false) private String frontWheel ;
    @Column(name="rearWheel",nullable = false) private String rearWheel;
    @Column(name="frontSuspension",nullable = false) private String frontSuspension;
    @Column(name="rearSuspension",nullable = false) private String rearSuspension ;
    @Column(name="frontBraking",nullable = false) private String frontBraking;
    @Column(name="rearBraking",nullable = false) private String rearBraking;
    @Column(name="steering",nullable = false) private String steering ;
    @Column(name="img",nullable = false) private String img;


}
