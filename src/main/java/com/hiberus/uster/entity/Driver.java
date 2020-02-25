package com.hiberus.uster.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver {

    private Long id;
    private String name;
    private String surName;
    private String license;

    public Driver(){

    }

    public Driver(String name, String surName, String license) {
        this.name = name;
        this.surName = surName;
        this.license = license;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surName", nullable = false)
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Column(name = "license", nullable = false)
    @Length(min = 1, max = 1)
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
}
