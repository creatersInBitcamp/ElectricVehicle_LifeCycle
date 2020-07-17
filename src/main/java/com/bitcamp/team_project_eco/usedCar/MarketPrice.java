package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "market_price")
public class MarketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;

    @Column(name = "car_type", nullable = false) private String carType;

    @Column(name = "depreciation_rate", nullable = false) private String depreciationRate;

    @Column(name = "manufacturing_yyyy_mm", nullable = false) private String manufacturingYyyyMm;

    @ManyToOne
    @JoinColumn(name = "car_id") private ElectricCar electricCar;
}
