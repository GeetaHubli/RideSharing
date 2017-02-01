package com.allstate.entities;

import com.allstate.enums.Cartype;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cars")
@Data
public class Car {
    private int id;
    private int version;
    private String make;
    private String model;
    private int year;
    private Cartype cartype;
    private Date created;
    private Date modified;

    public Car(String make, String model, int year, Cartype cartype) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.cartype = cartype;
    }

    public Car() {

    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @NotNull
    @Column(nullable = false, columnDefinition = "ENUM('BASIC','LUX')")
    @Enumerated(EnumType.STRING)
    public Cartype getCartype() {
        return cartype;
    }

    public void setCartype(Cartype cartype) {
        this.cartype = cartype;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

}