package com.bitcamp.team_project_eco.registration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="registration_cost",nullable = false) private Long id;
    @Column(name="insurance_start_date",nullable = false) private String insurance_start_date;
    @Column(name="insurance_termination_date",nullable = false) private String insurance_termination_date ;
    @Column(name="manufacturer",nullable = false) private String manufacturer;
    @Column(name="car_name",nullable = false) private String car_name;
    @Column(name="registration_year",nullable = false) private String registration_year;
    @Column(name="detailed_car_name",nullable = false) private String detailed_car_name;
    @Column(name="detailed_list",nullable = false) private String detailed_list;
    @Column(name="expected_insurance",nullable = false) private String expected_insurance;
    @Column(name="insurance_link",nullable = false) private String insurance_link;

}
