package com.hiberus.uster.dto;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TripDTO {
	
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("tripDate")
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

    public TripDTO(){

    }

    public TripDTO(Long id, LocalDate tripDate,
        Long driverId, String driverName, String driverSurname, String driverLicense, 
        Long vehicleId, String vehicleBranch, String vehicleModel, String vehiclePlate, String vehicleLicense) {
        this.id = id;
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
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

    public Long getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleBranch() {
        return vehicleBranch;
    }
    public void setVehicleBranch(String vehicleBranch) {
        this.vehicleBranch = vehicleBranch;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }
    public void setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense;
    }
}
