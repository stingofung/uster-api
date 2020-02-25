package com.hiberus.uster.dto;

public class VehicleDTO {
    private Long id;
    private String branch;
    private String model;
    private String plate;
    private String license;

    public VehicleDTO(){

    }

    public VehicleDTO(Long id, String branch, String model, String plate, String license) {
        this.id = id;
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

    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
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
}
