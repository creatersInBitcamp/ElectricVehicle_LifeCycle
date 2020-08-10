package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.purchase.Purchase;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "electric_car")
@NamedQuery(name = "ElectricCar.findByEccarId",
        query = "select e from ElectricCar e where  e.eccarId = :eccarId")
public class ElectricCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eccar_id") private Long eccarId;
    @Column(name = "car_name", nullable = false) private String carName;
    @Column(name = "yyyy", nullable = false) private String yyyy;
    @Column(name = "model_name", nullable = false) private String modelName;
    @Column(name = "trim", nullable = false) private String trim;
    @Column(name = "brand", nullable = false) private String brand;
    @Column(name = "price", nullable = false) private String price;
    @Column(name = "fuel", nullable = false) private String fuel;
    @Column(name = "fuel_efficiency", nullable = false) private String fuelEfficiency;
    @Column(name = "passengers_number", nullable = false) private String passengersNumber;
    @Column(name = "driving_method", nullable = false) private String drivingMethod;
    @Column(name = "transmission", nullable = false) private String transmission;
    @Column(name = "distance_driven", nullable = false) private String distanceDriven;
    @Column(name = "energy", nullable = false) private String energy;
    @Column(name = "maximum_output", nullable = false) private String maximumOutput;
    @Column(name = "maximum_torque", nullable = false) private String maximumTorque;
    @Column(name = "acceleration_performance", nullable = false) private String accelerationPerformance;
    @Column(name = "length", nullable = false) private String length;
    @Column(name = "width", nullable = false) private String width;
    @Column(name = "height", nullable = false) private String height;
    @Column(name = "wheel_base", nullable = false) private String wheelBase;
    @Column(name = "front_distance", nullable = false) private String frontDistance;
    @Column(name = "back_distance", nullable = false) private String backDistance;
    @Column(name = "weight", nullable = false) private String weight;
    @Column(name = "front_wheel", nullable = false) private String frontWheel;
    @Column(name = "rear_wheel", nullable = false) private String rearWheel;
    @Column(name = "front_suspension", nullable = false) private String frontSuspension;
    @Column(name = "rear_suspension", nullable = false) private String rearSuspension;
    @Column(name = "front_braking", nullable = false) private String frontBraking;
    @Column(name = "rear_braking", nullable = false) private String rearBraking;
    @Column(name = "steering", nullable = false) private String steering;
    @Column(name = "img", nullable = false) private String img;
    @Column(name = "boosting_charge", nullable = false) private String boostingCharge;
    @Column(name = "slow_charging", nullable = false) private String slowCharging;
    @Column(name = "color", nullable = false) private String color;
    @Column(name = "eol", nullable = false) private boolean eol;

    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL)
    private List<UsedCar> usedCarList;
    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL)
    private List<Purchase> purchasesList;
    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL)
    private List<Wishlist> wishlistList;

    public ElectricCar() {}

    @Builder
    public ElectricCar(String carName, String yyyy, String modelName,
                       String trim, String brand, String price,
                       String fuel, String fuelEfficiency, String passengersNumber,
                       String drivingMethod, String transmission, String distanceDriven, String energy,
                       String maximumOutput, String maximumTorque, String accelerationPerformance, String length,
                       String width, String height, String wheelBase, String frontDistance,
                       String backDistance, String weight, String frontWheel, String rearWheel,String frontSuspension,
                       String rearSuspension, String frontBraking, String rearBraking, String steering,
                       String img, String boostingCharge, String slowCharging, String color,
                       String eol) {
        this.carName = carName;
        this.yyyy = yyyy;
        this. modelName = modelName;
        this.trim = trim;
        this.brand = brand;
        this.price = price;
        this.fuel = fuel;
        this.fuelEfficiency = fuelEfficiency;
        this.passengersNumber = passengersNumber;
        this.drivingMethod = drivingMethod;
        this.transmission = transmission;
        this.distanceDriven = distanceDriven;
        this.energy = energy;
        this.maximumOutput = maximumOutput;
        this.maximumTorque = maximumTorque;
        this.accelerationPerformance = accelerationPerformance;
        this. length = length;
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
        this.img = img;
        this.boostingCharge = boostingCharge;
        this.slowCharging = slowCharging;
        this.color = color;
        this.eol = Boolean.parseBoolean(eol);
    }

}
