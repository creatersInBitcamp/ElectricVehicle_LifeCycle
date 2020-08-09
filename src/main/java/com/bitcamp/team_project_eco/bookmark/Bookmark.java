package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Bookmark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sight_id")
    private Sights sights;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cs_id")
    private ChargingStation chargingStation;

    public Bookmark(Long id, User user, Sights sights, ChargingStation chargingStation) {
        this.id = id;
        this.user = user;
        this.sights = sights;
        this.chargingStation = chargingStation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sights getSights() {
        return sights;
    }

    public void setSights(Sights sights) {
        this.sights = sights;
    }

    public ChargingStation getChargingStation() {
        return chargingStation;
    }

    public void setChargingStation(ChargingStation chargingStation) {
        this.chargingStation = chargingStation;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", user=" + user +
                ", sights=" + sights +
                ", chargingStation=" + chargingStation +
                '}';
    }
}
