package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="bookmark")
public class Bookmark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_id")
    private Long bookmarkId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sights_id")
    private Sights sights;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "charging_station_id")
    private ChargingStation chargingStation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

}
