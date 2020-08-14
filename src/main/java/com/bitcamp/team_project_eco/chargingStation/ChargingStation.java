package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"bookmarkList"})
@Table(name="charging_station")
public class ChargingStation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charging_station_id") private Long chargingStationId;
    @Column(name = "unit_name") private String unitName;
    @Column(name = "charger_id") private String chargerId;
    @Column(name = "charger_type_id") private int chargerTypeID;
    @Column(name = "charger_type") private String chargerType;
    @Column(name = "charger_state") private String chargerState;
    @Column(name = "address") private String address;
    @Column(name = "x_value") private double xValue;
    @Column(name = "y_value") private double yValue;
    @Column(name = "business_hours") private String businessHours;
    @Column(name = "agency_name") private String agencyName;
    @Column(name = "phone") private String phone;
    @Column(name = "update_date") private String updateDate;
    @Column(name = "boosting_charge") private String boostingCharge;
    @Column(name = "category") private String category;

    @OneToMany(mappedBy = "chargingStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bookmark> bookmarkList = new ArrayList<>();

    public ChargingStation(){}

    @Builder
    public ChargingStation (String unitName, String chargerId, int chargerTypeID, String chargerType,
                            String chargerState, String address, double xValue, double yValue, String businessHours,
                            String agencyName, String phone, String updateDate,
                            String boostingCharge, String category,
                            List<Bookmark> bookmarkList) {
        this.unitName = unitName;
        this.chargerId = chargerId;
        this.chargerType = chargerType;
        this.chargerTypeID = chargerTypeID;
        this.address = address;
        this.xValue = xValue;
        this.yValue = yValue;
        this.businessHours = businessHours;
        this.agencyName = agencyName;
        this.phone = phone;
        this.chargerState = chargerState;
        this.updateDate = updateDate;
        this.boostingCharge = boostingCharge;
        this.category = category;
        this.bookmarkList.addAll(bookmarkList);
    }
}
