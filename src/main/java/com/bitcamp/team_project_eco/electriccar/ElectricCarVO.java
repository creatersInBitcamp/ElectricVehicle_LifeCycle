package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.purchase.Purchase;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.variants.Variants;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter @Setter
public class ElectricCarVO {
    Long eccarId;
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
    List<String> colors;
    boolean sale;
    List<String> pictures;
    String shortDetails;
    boolean New;
    String video;
    String date;
    List<UsedCar> usedCarList;
    List<Purchase> purchasesList;
    List<Wishlist> wishlistList;
    List<Variants> variants;
}
