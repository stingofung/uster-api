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
    private LocalDate tripDate;

    private Long driverId;
    private String driverName;
    private String driverSurname;
    private String driverLicense;

    private Long vehicleId;
    private String vehicleBranch;
    private String vehicleModel;
    private String vehiclePlate;
    private String vehicleLicense;

//    @ManyToOne
//    @JoinColumn("vehicle_id")
//    private Vehicle vehicle;

    public Trip(){

    }

    public Trip(LocalDate tripDate,
            Long driverId, String driverName, String driverSurname, String driverLicense, 
            Long vehicleId, String vehicleBranch, String vehicleModel, String vehiclePlate, String vehicleLicense) {
    	this.tripDate = tripDate;
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverSurname = driverSurname;
        this.driverLicense = driverLicense;
        this.vehicleId = vehicleId;
        this.vehicleBranch = vehicleBranch;
        this.vehicleModel = vehicleModel;
        this.vehiclePlate = vehiclePlate;
        this.vehicleLicense = vehicleLicense;
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

    @Column(name = "tripDate", nullable = false)
    public LocalDate getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
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

    @Column(name = "vehicleId", nullable = false)
    public Long getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Column(name = "vehicleBranch", nullable = false)
    public String getVehicleBranch() {
        return vehicleBranch;
    }
    public void setVehicleBranch(String vehicleBranch) {
        this.vehicleBranch = vehicleBranch;
    }

    @Column(name = "vehicleModel", nullable = false)
    public String getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Column(name = "vehiclePlate", nullable = false)
    public String getVehiclePlate() {
        return vehiclePlate;
    }
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    @Column(name = "vehicleLicense", nullable = false)
    public String getVehicleLicense() {
        return vehicleLicense;
    }
    public void setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense;
    }
}
