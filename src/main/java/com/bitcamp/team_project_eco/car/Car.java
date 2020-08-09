package com.bitcamp.team_project_eco.car;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id",nullable = false) private Long carId;
    @Column(name="car_name",nullable = false) private String carName;
    @Column(name="brand",nullable = false) private String brand ;
    @Column(name="price",nullable = false) private String price ;
    @Column(name="engine_type",nullable = false) private String engineType  ;
    @Column(name="supercharge_method",nullable = false) private String superchargeMethod;
    @Column(name="exhaust_volume",nullable = false) private String exhaustVolume;
    @Column(name="fuel",nullable = false) private String fuel;
    @Column(name="fuel_efficiency",nullable = false) private String fuelEfficiency;
    @Column(name="passengers_number",nullable = false) private String passengersNumber ;
    @Column(name="driving_method",nullable = false) private String drivingMethod;
    @Column(name="transmission",nullable = false) private String transmission;
    @Column(name="maximum_output",nullable = false) private String maximumOutput ;
    @Column(name="maximum_torque",nullable = false) private String maximumTorque;
    @Column(name="top_Speed",nullable = false) private String topSpeed;
    @Column(name="acceleration_performance",nullable = false) private String accelerationPerformance ;
    @Column(name="CO2_emissions",nullable = false) private String CO2Emissions;
    @Column(name="length",nullable = false) private String length ;
    @Column(name="width",nullable = false) private String width;
    @Column(name="height",nullable = false) private String height;
    @Column(name="wheel_base",nullable = false) private String wheelBase ;
    @Column(name="front_distance",nullable = false) private String frontDistance;
    @Column(name="back_distance",nullable = false) private String backDistance;
    @Column(name="weight",nullable = false) private String weight;
    @Column(name="front_wheel",nullable = false) private String frontWheel ;
    @Column(name="rear_wheel",nullable = false) private String rearWheel;
    @Column(name="front_suspension",nullable = false) private String frontSuspension;
    @Column(name="rear_suspension",nullable = false) private String rearSuspension ;
    @Column(name="front_braking",nullable = false) private String frontBraking;
    @Column(name="rear_braking",nullable = false) private String rearBraking;
    @Column(name="steering",nullable = false) private String steering ;
    @Column(name="img",nullable = false) private String img;

    @Builder
    private Car(Long carId,
                String carName,
                String brand,
                String price,
                String engineType,
                String superchargeMethod,
                String exhaustVolume,
                String fuel,
                String fuelEfficiency,
                String passengersNumber,
                String drivingMethod,
                String transmission,
                String maximumOutput,
                String maximumTorque,
                String topSpeed,
                String accelerationPerformance,
                String CO2Emissions,
                String length,
                String width,
                String height,
                String wheelBase,
                String frontDistance,
                String backDistance,
                String weight,
                String frontWheel,
                String rearWheel,
                String frontSuspension,
                String rearSuspension,
                String frontBraking,
                String rearBraking,
                String steering,
                String img){
        this.carId = carId;
        this.carName = carName;
        this.brand = brand;
        this.price = price;
        this.engineType = engineType;
        this.superchargeMethod = superchargeMethod;
        this.exhaustVolume = exhaustVolume;
        this.fuel = fuel;
        this.fuelEfficiency = fuelEfficiency;
        this.passengersNumber = passengersNumber;
        this.drivingMethod = drivingMethod;
        this.transmission = transmission;
        this.maximumOutput = maximumOutput;
        this.maximumTorque = maximumTorque;
        this.topSpeed = topSpeed;
        this.accelerationPerformance = accelerationPerformance;
        this.CO2Emissions = CO2Emissions;
        this.length = length;
        this.width = width;
        this.height = height;
        this.wheelBase = wheelBase;
        this.frontDistance = frontDistance;
        this.backDistance = backDistance;
        this.weight = weight;
        this.frontWheel = frontWheel;
        this.rearWheel = rearWheel;
        this.frontSuspension = frontSuspension;
        this.rearSuspension = rearSuspension;
        this.frontBraking = frontBraking;
        this.rearBraking = rearBraking;
        this.steering = steering;
        this. img = img;
    }
}
