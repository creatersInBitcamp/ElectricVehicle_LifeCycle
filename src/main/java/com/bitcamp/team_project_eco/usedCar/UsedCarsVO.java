package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.usedCarSales.UsedCarSales;
import com.bitcamp.team_project_eco.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UsedCarsVO {
    Long usedCarId;
    String price;
    String age;
    String mileage;
    boolean sale;
    boolean main;
    Img img;
    User user;
    String carName;
    String yyyy;
    String modelName;
    String trim;
    String brand;
    List<String> pictures;
    List<UsedCarSales> usedCarSalesList;
}
