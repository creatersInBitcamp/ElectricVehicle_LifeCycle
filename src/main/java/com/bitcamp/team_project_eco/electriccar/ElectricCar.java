package com.bitcamp.team_project_eco.electriccar;


import javax.persistence.*;

@Entity
@Table(name = "electric_car")
public class ElectricCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id") private Long id;

    @Column(name = "manufacturer", nullable = false) private String manufacturer;

    @Column(name = "trim", nullable = false) private String trim;

    @Column(name = "manufacturing_yyyy_mm", nullable = false) private String manufacturingYyyyMm;

    @Column(name = "price", nullable = false) private String price;

    @Column(name = "fuel_efficiency", nullable = false) private String fuelEfficiency;

    @Column(name = "rapid_charging", nullable = false) private String rapidCharging;

    @Column(name = "slow_charging", nullable = false) private String slowCharging;

    @Column(name = "mileage", nullable = false) private String mileage;

    @Column(name = "battery_capacity", nullable = false) private String batteryCapacity;

    @Column(name = "subsidy", nullable = false) private String subsidy;

    @Column(name = "production_site", nullable = false) private String productionSite;

    @Column(name = "color", nullable = false) private String color;

    @Column(name = "technical_option", nullable = false) private String technicalOption;

    @Column(name = "design_option", nullable = false) private String designOption;

    public ElectricCar(Long id, String manufacturer, String trim, String manufacturingYyyyMm, String price, String fuelEfficiency, String rapidCharging, String slowCharging, String mileage, String batteryCapacity, String subsidy, String productionSite, String color, String technicalOption, String designOption) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.trim = trim;
        this.manufacturingYyyyMm = manufacturingYyyyMm;
        this.price = price;
        this.fuelEfficiency = fuelEfficiency;
        this.rapidCharging = rapidCharging;
        this.slowCharging = slowCharging;
        this.mileage = mileage;
        this.batteryCapacity = batteryCapacity;
        this.subsidy = subsidy;
        this.productionSite = productionSite;
        this.color = color;
        this.technicalOption = technicalOption;
        this.designOption = designOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getManufacturingYyyyMm() {
        return manufacturingYyyyMm;
    }

    public void setManufacturingYyyyMm(String manufacturingYyyyMm) {
        this.manufacturingYyyyMm = manufacturingYyyyMm;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(String fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getRapidCharging() {
        return rapidCharging;
    }

    public void setRapidCharging(String rapidCharging) {
        this.rapidCharging = rapidCharging;
    }

    public String getSlowCharging() {
        return slowCharging;
    }

    public void setSlowCharging(String slowCharging) {
        this.slowCharging = slowCharging;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy;
    }

    public String getProductionSite() {
        return productionSite;
    }

    public void setProductionSite(String productionSite) {
        this.productionSite = productionSite;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTechnicalOption() {
        return technicalOption;
    }

    public void setTechnicalOption(String technicalOption) {
        this.technicalOption = technicalOption;
    }

    public String getDesignOption() {
        return designOption;
    }

    public void setDesignOption(String designOption) {
        this.designOption = designOption;
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", trim='" + trim + '\'' +
                ", manufacturingYyyyMm='" + manufacturingYyyyMm + '\'' +
                ", price='" + price + '\'' +
                ", fuelEfficiency='" + fuelEfficiency + '\'' +
                ", rapidCharging='" + rapidCharging + '\'' +
                ", slowCharging='" + slowCharging + '\'' +
                ", mileage='" + mileage + '\'' +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", subsidy='" + subsidy + '\'' +
                ", productionSite='" + productionSite + '\'' +
                ", color='" + color + '\'' +
                ", technicalOption='" + technicalOption + '\'' +
                ", designOption='" + designOption + '\'' +
                '}';
    }
}
