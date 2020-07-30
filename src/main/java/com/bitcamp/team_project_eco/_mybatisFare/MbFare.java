package com.bitcamp.team_project_eco._mybatisFare;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class MbFare {
    public int fareId;
    public String
            startName,
            arriveName,
            typeOne,
            typeTwo,
            typeThree,
            typeFour,
            typeFive,
            typeLightCar;
}
