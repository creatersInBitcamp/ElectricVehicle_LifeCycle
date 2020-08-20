package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = {"bookmarkList"})
@Table(name = "sights")
public class Sights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sights_id") private Long sightsId;
    @Column(name = "name") private String name;
    @Column(name = "street_address") private String streetAddress;
    @Column(name = "branch_address") private String branchAddress;
    @Column(name = "x_value") private double xValue;
    @Column(name = "y_value") private double yValue;
    @Column(name = "capacity") private int capacity;
    @Column(name = "parking_lot") private int parkingLot;
    @Column(name = "info", length = 700) private String info;
    @Column(name = "category") private String category;

    @OneToMany(mappedBy = "sights",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bookmark> bookmarkList = new ArrayList<>();

    public Sights(){}

    @Builder
    public Sights (String name, String streetAddress, String branchAddress,
                   double xValue, double yValue, int capacity,
                   int parkingLot, String info, String category,
                   List<Bookmark> bookmarkList) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.branchAddress = branchAddress;
        this.xValue = xValue;
        this.yValue = yValue;
        this.capacity = capacity;
        this.parkingLot = parkingLot;
        this.info = info;
        this.category = category;
        this.bookmarkList.addAll(bookmarkList);
    }
}
