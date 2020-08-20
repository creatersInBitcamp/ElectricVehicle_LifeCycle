package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.purchase.Purchase;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.variants.Variants;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = {"usedCarList","purchasesList","wishlistList","variants"})
@Table(name = "electric_car")
public class ElectricCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eccar_id") private Long eccarId;
    @Column(name = "car_name") private String carName;
    @Column(name = "yyyy") private String yyyy;
    @Column(name = "model_name") private String modelName;
    @Column(name = "trim") private String trim;
    @Column(name = "brand") private String brand;
    @Column(name = "price") private String price;
    @Column(name = "fuel") private String fuel;
    @Column(name = "fuel_efficiency") private String fuelEfficiency;
    @Column(name = "passengers_number") private String passengersNumber;
    @Column(name = "driving_method") private String drivingMethod;
    @Column(name = "transmission") private String transmission;
    @Column(name = "distance_driven") private String distanceDriven;
    @Column(name = "energy") private String energy;
    @Column(name = "maximum_output") private String maximumOutput;
    @Column(name = "maximum_torque") private String maximumTorque;
    @Column(name = "acceleration_performance") private String accelerationPerformance;
    @Column(name = "length") private String length;
    @Column(name = "width") private String width;
    @Column(name = "height") private String height;
    @Column(name = "wheel_base") private String wheelBase;
    @Column(name = "front_distance") private String frontDistance;
    @Column(name = "back_distance") private String backDistance;
    @Column(name = "weight") private String weight;
    @Column(name = "front_wheel") private String frontWheel;
    @Column(name = "rear_wheel") private String rearWheel;
    @Column(name = "front_suspension") private String frontSuspension;
    @Column(name = "rear_suspension") private String rearSuspension;
    @Column(name = "front_braking") private String frontBraking;
    @Column(name = "rear_braking") private String rearBraking;
    @Column(name = "steering") private String steering;
    @Column(name = "img") private String img;
    @Column(name = "boosting_charge") private String boostingCharge;
    @Column(name = "slow_charging") private String slowCharging;
    @Column(name = "color1") private String color1;
    @Column(name = "color2") private String color2;
    @Column(name = "color3") private String color3;
    @Column(name = "color4") private String color4;
    @Column(name = "color5") private String color5;
    @Column(name = "color6") private String color6;
    @Column(name = "sale") private boolean sale;
    @Column(name = "picture1") private String picture1;
    @Column(name = "picture2") private String picture2;
    @Column(name = "picture3") private String picture3;
    @Column(name = "picture4") private String picture4;
    @Column(name = "picture5") private String picture5;
    @Column(name = "picture6") private String picture6;
    @Column(name = "picture7") private String picture7;
    @Column(name = "picture8") private String picture8;
    @Column(name = "picture9") private String picture9;
    @Column(name = "picture10") private String picture10;
    @Column(name = "picture11") private String picture11;
    @Column(name = "picture12") private String picture12;
    @Column(name = "picture13") private String picture13;
    @Column(name = "picture14") private String picture14;
    @Column(name = "picture15") private String picture15;
    @Column(name = "picture16") private String picture16;
    @Column(name = "picture17") private String picture17;
    @Column(name = "picture18") private String picture18;
    @Column(name = "short_details") private String shortDetails;
    @Column(name = "new") private boolean New;
    @Column(name = "video") private String video;

    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<UsedCar> usedCarList = new ArrayList<>();
    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Purchase> purchasesList = new ArrayList<>();
    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Wishlist> wishlistList = new ArrayList<>();
    @OneToMany(mappedBy = "electricCar", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Variants> variants = new ArrayList<>();


    public ElectricCar() {}

    @Builder
    public ElectricCar(String carName,
                       String yyyy,
                       String modelName,
                       String trim,
                       String brand,
                       String price,
                       String fuel,
                       String fuelEfficiency,
                       String passengersNumber,
                       String drivingMethod,
                       String transmission,
                       String distanceDriven,
                       String energy,
                       String maximumOutput,
                       String maximumTorque,
                       String accelerationPerformance,
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
                       String img,
                       String boostingCharge,
                       String slowCharging,
                       String color1,String color2,String color3,String color4,String color5,String color6,
                       boolean sale,
                       String picture1,String picture2,String picture3,String picture4,
                       String picture5,String picture6,String picture7,String picture8,
                       String picture9,String picture10,String picture11,String picture12,
                       String picture13,String picture14,String picture15,String picture16,
                       String picture17, String picture18,
                       String shortDetails,
                       boolean New,
                       String video,
                       List<UsedCar> usedCarList,
                       List<Purchase> purchasesList,
                       List<Wishlist> wishlistList,
                       List<Variants> variants) {
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
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
        this.color5 = color5;
        this.color6 = color6;
        this.sale = sale;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.picture4 = picture4;
        this.picture5 = picture5;
        this.picture6 = picture6;
        this.picture7 = picture7;
        this.picture8 = picture8;
        this.picture9 = picture9;
        this.picture10 = picture10;
        this.picture11 = picture11;
        this.picture12 = picture12;
        this.picture13 = picture13;
        this.picture14 = picture14;
        this.picture15 = picture15;
        this.picture16 = picture16;
        this.picture17 = picture17;
        this.picture18 = picture18;
        this.shortDetails = shortDetails;
        this.New = New;
        this.video = video;
        this.usedCarList.addAll(usedCarList);
        this.purchasesList.addAll(purchasesList);
        this.wishlistList.addAll(wishlistList);
        this.variants.addAll(variants);
    }

}
