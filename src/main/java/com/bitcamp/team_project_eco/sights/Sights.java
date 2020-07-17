package com.bitcamp.team_project_eco.sights;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "sights")
public class Sights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sights_id") private Long id;
    @Column(name = "name", nullable = false) private String name;
    @Column(name = "street_address", nullable = false) private String streetAddress;
    @Column(name = "branch_address", nullable = false) private String branchAddress;
    @Column(name = "x_value", nullable = false) private String xValue;
    @Column(name = "y_value", nullable = false) private String yValue;
    @Column(name = "capacity", nullable = false) private int capacity;
    @Column(name = "parking_lot", nullable = false) private int parkingLot;
    @Column(name = "info", nullable = false) private String info;
}
