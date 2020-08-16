package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.purchase.Purchase;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.variants.Variants;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ElectricCarVO {
    String carName;
    String yyyy;
    String modelName;
    String trim;
    String brand;
    String price;
    String fuel;
    String fuelEfficiency;
    String passengersNumber;
    String drivingMethod;
    String transmission;
    String distanceDriven;
    String energy;
    String maximumOutput;
    String maximumTorque;
    String accelerationPerformance;
    String length;
    String width;
    String height;
    String wheelBase;
    String frontDistance;
    String backDistance;
    String weight;
    String frontWheel;
    String rearWheel;
    String frontSuspension;
    String rearSuspension;
    String frontBraking;
    String rearBraking;
    String steering;
    String img;
    String boostingCharge;
    String slowCharging;
    String color1;String color2;String color3;String color4;String color5;String color6;
    boolean sale;
    String picture1;String picture2;String picture3;String picture4;
    String picture5;String picture6;String picture7;String picture8;
    String picture9;String picture10;String picture11;String picture12;
    String picture13;String picture14;String picture15;String picture16;
    String picture17; String picture18;
    String shortDetails;
    boolean New;
    String video;
    List<UsedCar> usedCarList;
    List<Purchase> purchasesList;
    List<Wishlist> wishlistList;
    List<Variants> variants;
}
