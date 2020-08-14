package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = {"sights","chargingStation","user"})
@Table(name="bookmark")
@NamedQuery(name = "Bookmark.findByBookmarkId",
        query = "select e from Bookmark e where e.bookmarkId = :bookmarkId")
public class Bookmark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_id")
    private Long bookmarkId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sights_id")
    private Sights sights;

    public void setSights(Sights sights){
        this.sights = sights;
    }


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "charging_station_id")
    private ChargingStation chargingStation;

    public void setChargingStation(ChargingStation chargingStation){
        this.chargingStation = chargingStation;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    public Bookmark(){}

    public Bookmark(Long bookmarkId, Sights sights, ChargingStation chargingStation, User user){
        this.bookmarkId = bookmarkId;
        setSights(sights);
        setChargingStation(chargingStation);
        setUser(user);
    }
}
