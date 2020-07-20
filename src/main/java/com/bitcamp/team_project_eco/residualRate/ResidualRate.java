package com.bitcamp.team_project_eco.residualRate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "residual_rate")
public class ResidualRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_type") private Long id;

    @Column(name = "durable_years") private String durableYears;

    @Column(name = "one_year") private int oneYear;

    @Column(name = "two_years") private int twoYears;

    @Column(name = "three_years") private int threeYears;

    @Column(name = "four_years") private int fourYears;

    @Column(name = "five_years") private int fiveYears;
}
