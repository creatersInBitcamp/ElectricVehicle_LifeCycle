package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.bitcamp.team_project_eco.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsedCarVO {
    boolean sale;
    String price, age, mileage;
    Long usedCarId;
    Long eccarId;
    Long userSeq;
}
