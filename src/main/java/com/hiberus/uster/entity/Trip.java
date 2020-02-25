package com.hiberus.uster.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "driverId", nullable = false)
    private Long driverId;
    @Column(name = "driverName", nullable = false)
    private String driverName;
    @Column(name = "driverSurname", nullable = false)
    private String driverSurname;
    @Column(name = "driverLicense", nullable = false)
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDriverId() {
        return driverId;
    }
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }
    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }

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
