package com.bitcamp.team_project_eco.sights;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public Sights(Long id, String name, String streetAddress, String branchAddress, String xValue, String yValue, int capacity, int parkingLot, String info) {
        this.id = id;
        this.name = name;
        this.streetAddress = streetAddress;
        this.branchAddress = branchAddress;
        this.xValue = xValue;
        this.yValue = yValue;
        this.capacity = capacity;
        this.parkingLot = parkingLot;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getxValue() {
        return xValue;
    }

    public void setxValue(String xValue) {
        this.xValue = xValue;
    }

    public String getyValue() {
        return yValue;
    }

    public void setyValue(String yValue) {
        this.yValue = yValue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(int parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Sights{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", xValue='" + xValue + '\'' +
                ", yValue='" + yValue + '\'' +
                ", capacity=" + capacity +
                ", parkingLot=" + parkingLot +
                ", info='" + info + '\'' +
                '}';
    }
}
