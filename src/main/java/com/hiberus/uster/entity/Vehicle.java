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
    private String branch;
    private String model;
    private String plate;
    private String license;

    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    private Trip trip;

    public Vehicle(){

    }

    public Vehicle(String branch, String model, String plate, String license) {
        this.branch = branch;
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

    @Column(name = "branch", nullable = false)
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "plate", nullable = false)
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Column(name = "license", nullable = false)
    @Length(min = 1, max = 1)
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
