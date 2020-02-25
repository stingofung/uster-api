package com.hiberus.uster.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private LocalDate date;

    private Long driverId;
    private String driverName;
    private String driverSurname;
    private String driverLicense;

//    private Long vehicleId;
//    private String vehicleBranch;
//    private String vehicleModel;
//    private String vehiclePlate;
//    private String vehicleLicense;

    //@OneToOne
    //@MapsId
    //private Vehicle vehicle;

    public Trip(){

    }

    public Trip(LocalDate date,
            Long driverId, String driverName, String driverSurname, String driverLicense, 
            Long vehicleId, String vehicleBranch, String vehicleModel, String vehiclePlate, String vehicleLicense) {
    	this.date = date;
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverSurname = driverSurname;
        this.driverLicense = driverLicense;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "driverId", nullable = false)
    public Long getDriverId() {
        return driverId;
    }
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Column(name = "driverName", nullable = false)
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Column(name = "driverSurname", nullable = false)
    public String getDriverSurname() {
        return driverSurname;
    }
    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }

    @Column(name = "driverLicense", nullable = false)
    public String getDriverLicense() {
        return driverLicense;
    }
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    //@Column(name = "vehicle")
    /*public Vehicle getVehicle() {
        return vehicle;
    }*/

    /*public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/
}
