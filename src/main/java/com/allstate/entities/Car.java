package com.allstate.entities;

import com.allstate.enums.Cartype;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="cars")
@Data
public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private Cartype cartype;

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
}
