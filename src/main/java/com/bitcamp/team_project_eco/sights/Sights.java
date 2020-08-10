package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "sights")
public class Sights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sights_id") private Long sightsId;
    @Column(name = "name", nullable = false) private String name;
    @Column(name = "street_address", nullable = false) private String streetAddress;
    @Column(name = "branch_address", nullable = false) private String branchAddress;
    @Column(name = "x_value", nullable = false) private double xValue;
    @Column(name = "y_value", nullable = false) private double yValue;
    @Column(name = "capacity", nullable = false) private int capacity;
    @Column(name = "parking_lot", nullable = false) private int parkingLot;
    @Column(name = "info", nullable = false) private String info;

    @OneToMany(mappedBy = "sights", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarkList;

    @Builder
    public Sights (String name, String streetAddress, String branchAddress,
                   double xValue, double yValue, int capacity,
                   int parkingLot, String info) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.branchAddress = branchAddress;
        this.xValue = xValue;
        this.yValue = yValue;
        this.capacity = capacity;
        this.parkingLot = parkingLot;
        this.info = info;
    }
}
