package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChargingStaionAdminVO {
    String name;
    String chargerId;
    int chargerTypeID;
    String chargerType;
    String chargerState;
    String address;
    double xValue;
    double yValue;
    String businessHours;
    String agencyName;
    String phone;
    String updateDate;
    String boostingCharge;
    String category;
}
