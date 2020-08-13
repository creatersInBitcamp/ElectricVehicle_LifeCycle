package com.bitcamp.team_project_eco.car;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id"  ) private Long carId;
    @Column(name="car_name") private String carName;
    @Column(name="brand") private String brand ;
    @Column(name="price"  ) private String price ;
    @Column(name="engine_type"  ) private String engineType  ;
    @Column(name="supercharge_method"  ) private String superchargeMethod;
    @Column(name="exhaust_volume"  ) private String exhaustVolume;
    @Column(name="fuel"  ) private String fuel;
      @Column(name="fuel_efficiency"  ) private String fuelEfficiency;
    @Column(name="passengers_number"  ) private String passengersNumber ;
    @Column(name="driving_method"  ) private String drivingMethod;
    @Column(name="transmission"  ) private String transmission;
    @Column(name="maximum_output"  ) private String maximumOutput ;
    @Column(name="maximum_torque"  ) private String maximumTorque;
    @Column(name="top_Speed"  ) private String topSpeed;
    @Column(name="acceleration_performance"  ) private String accelerationPerformance ;
    @Column(name="CO2_emissions"  ) private String CO2Emissions;
    @Column(name="length"  ) private String length ;
    @Column(name="width"  ) private String width;
    @Column(name="height"  ) private String height;
    @Column(name="wheel_base"  ) private String wheelBase ;
    @Column(name="front_distance"  ) private String frontDistance;
    @Column(name="back_distance"  ) private String backDistance;
    @Column(name="weight"  ) private String weight;
    @Column(name="front_wheel"  ) private String frontWheel ;
    @Column(name="rear_wheel"  ) private String rearWheel;
    @Column(name="front_suspension"  ) private String frontSuspension;
    @Column(name="rear_suspension"  ) private String rearSuspension ;
    @Column(name="front_braking"  ) private String frontBraking;
    @Column(name="rear_braking"  ) private String rearBraking;
    @Column(name="steering"  ) private String steering ;
    @Column(name="img"  ) private String img;

    public Car(){}

    @Builder
    public Car(
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
