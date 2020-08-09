package com.bitcamp.team_project_eco.chargingStation;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class ChargingStation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_id") private Long id;

}
