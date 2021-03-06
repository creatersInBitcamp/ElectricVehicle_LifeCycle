package com.bitcamp.team_project_eco.fare;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@Entity
@Table(name = "fare")
public class Fare {
    @Id
    @Column(name = "fare_id", nullable = false) private Long id;
    @Column(name = "start_name", nullable = false) private String startName;
    @Column(name = "arrive_name", nullable = false) private String arriveName;
    @Column(name = "type_one", nullable = false) private String typeOne;
    @Column(name = "type_two", nullable = false) private String typeTwo;
    @Column(name = "type_three", nullable = false) private String typeThree;
    @Column(name = "type_four", nullable = false) private String typeFour;
    @Column(name = "type_five", nullable = false) private String typeFive;
    @Column(name = "type_light_car", nullable = false) private String typeLightCar;

    public Fare() {
    }

    public Fare(Long id,
                String startName,
                String arriveName,
                String typeOne,
                String typeTwo,
                String typeThree,
                String typeFour,
                String typeFive,
                String typeLightCar) {
        this.id = id;
        this.startName = startName;
        this.arriveName = arriveName;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.typeThree = typeThree;
        this.typeFour = typeFour;
        this.typeFive = typeFive;
        this.typeLightCar = typeLightCar;
    }
}
