package com.bitcamp.team_project_eco.usedCar;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarInfo {
    Long usedCarId;
    String price, age, mileage, carName,
            yyyy, modelName, trim, brand;
    Img img;
}
