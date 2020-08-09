package com.bitcamp.team_project_eco.chargingStation;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class ChargingStation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_id") private Long id;

    public ChargingStation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChargingStation{" +
                "id=" + id +
                '}';
    }
}
