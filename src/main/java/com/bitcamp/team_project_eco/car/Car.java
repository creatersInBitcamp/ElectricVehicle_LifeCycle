package com.bitcamp.team_project_eco.car;


import lombok.*;

import javax.persistence.*;

@Entity
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

    public Car(Long carId, String carName, String price, String engineType, String superchargeMethod, String exhaustVolume, String fuel, String fuelEfficiency, String passengersNumber, String drivingMethod, String transmission, String maximumOutput, String maximumTorque, String topSpeed, String accelerationPerformance, String brakingPerformance, String CO2Emissions, String length, String fullWidth, String height, String wheelBase, String frontDistance, String backDistance, String weight, String frontWheel, String rearWheel, String frontSuspension, String rearSuspension, String frontBraking, String rearBraking, String steering, String img) {
        this.carId = carId;
        this.carName = carName;
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
        this.brakingPerformance = brakingPerformance;
        this.CO2Emissions = CO2Emissions;
        this.length = length;
        this.fullWidth = fullWidth;
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
        this.img = img;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getSuperchargeMethod() {
        return superchargeMethod;
    }

    public void setSuperchargeMethod(String superchargeMethod) {
        this.superchargeMethod = superchargeMethod;
    }

    public String getExhaustVolume() {
        return exhaustVolume;
    }

    public void setExhaustVolume(String exhaustVolume) {
        this.exhaustVolume = exhaustVolume;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(String fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(String passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public String getDrivingMethod() {
        return drivingMethod;
    }

    public void setDrivingMethod(String drivingMethod) {
        this.drivingMethod = drivingMethod;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getMaximumOutput() {
        return maximumOutput;
    }

    public void setMaximumOutput(String maximumOutput) {
        this.maximumOutput = maximumOutput;
    }

    public String getMaximumTorque() {
        return maximumTorque;
    }

    public void setMaximumTorque(String maximumTorque) {
        this.maximumTorque = maximumTorque;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getAccelerationPerformance() {
        return accelerationPerformance;
    }

    public void setAccelerationPerformance(String accelerationPerformance) {
        this.accelerationPerformance = accelerationPerformance;
    }

    public String getBrakingPerformance() {
        return brakingPerformance;
    }

    public void setBrakingPerformance(String brakingPerformance) {
        this.brakingPerformance = brakingPerformance;
    }

    public String getCO2Emissions() {
        return CO2Emissions;
    }

    public void setCO2Emissions(String CO2Emissions) {
        this.CO2Emissions = CO2Emissions;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(String fullWidth) {
        this.fullWidth = fullWidth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(String wheelBase) {
        this.wheelBase = wheelBase;
    }

    public String getFrontDistance() {
        return frontDistance;
    }

    public void setFrontDistance(String frontDistance) {
        this.frontDistance = frontDistance;
    }

    public String getBackDistance() {
        return backDistance;
    }

    public void setBackDistance(String backDistance) {
        this.backDistance = backDistance;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFrontWheel() {
        return frontWheel;
    }

    public void setFrontWheel(String frontWheel) {
        this.frontWheel = frontWheel;
    }

    public String getRearWheel() {
        return rearWheel;
    }

    public void setRearWheel(String rearWheel) {
        this.rearWheel = rearWheel;
    }

    public String getFrontSuspension() {
        return frontSuspension;
    }

    public void setFrontSuspension(String frontSuspension) {
        this.frontSuspension = frontSuspension;
    }

    public String getRearSuspension() {
        return rearSuspension;
    }

    public void setRearSuspension(String rearSuspension) {
        this.rearSuspension = rearSuspension;
    }

    public String getFrontBraking() {
        return frontBraking;
    }

    public void setFrontBraking(String frontBraking) {
        this.frontBraking = frontBraking;
    }

    public String getRearBraking() {
        return rearBraking;
    }

    public void setRearBraking(String rearBraking) {
        this.rearBraking = rearBraking;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
