package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name="charging_station")
public class ChargingStation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charging_station_id") private Long chargingStationId;
    @Column(name = "unit_name") private String unitName;
    @Column(name = "charger_id") private String chargerId;
    @Column(name = "charger_type") private int chargerType;
    @Column(name = "address") private String address;
    @Column(name = "x_value") private int xValue;
    @Column(name = "y_value") private int yValue;
    @Column(name = "business_hours") private String businessHours;
    @Column(name = "agency_name") private String agencyName;
    @Column(name = "phone") private String phone;
    @Column(name = "charger_state") private String chargerState;
    @Column(name = "update_date") private String updateDate;
    @Column(name = "boosting_charge") private String boostingCharge;

    @OneToMany(mappedBy = "bookmark", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarkList;

    public ChargingStation(){}

    @Builder
    public ChargingStation (String unitName, String chargerId, int chargerType,
                            String address, int xValue, int yValue, String businessHours,
                            String agencyName, String phone, String chargerState, String updateDate,
                            String boostingCharge) {
        this.unitName = unitName;
        this.chargerId = chargerId;
        this.chargerType = chargerType;
        this.address = address;
        this.xValue = xValue;
        this.yValue = yValue;
        this.businessHours = businessHours;
        this.agencyName = agencyName;
        this.phone = phone;
        this.chargerState = chargerState;
        this.updateDate = updateDate;
        this.boostingCharge = boostingCharge;
    }
}
