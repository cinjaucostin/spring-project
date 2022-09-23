package com.costin.erm.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_profile")
public class CarProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fabrication_year")
    private int fabricationYear;

    @Column(name = "engine")
    private String engine;

    @Column(name = "power")
    private String power;

    @Column(name = "price")
    private Long price;

    @Column(name = "photo_location")
    private String photoLocation;

    public CarProfile() {

    }

    public CarProfile(int fabricationYear, String engine, String power, Long price, String photoLocation) {
        this.fabricationYear = fabricationYear;
        this.engine = engine;
        this.power = power;
        this.price = price;
        this.photoLocation = photoLocation;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
