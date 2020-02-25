package com.hiberus.uster.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "plate", nullable = false)
    private String plate;
    @Column(name = "license", nullable = false)
    @Length(min = 1, max = 1)
    private String license;

    //@OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    //private Trip trip;

    public Vehicle(){

    }

    public Vehicle(String brand, String model, String plate, String license) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.license = license;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBranch() {
        return brand;
    }
    public void setBranch(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }

    /*public Trip getTrip() {
        return trip;
    }*/

    /*public void setTrip(Trip trip) {
        this.trip = trip;
    }*/
}
