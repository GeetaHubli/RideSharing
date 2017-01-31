package com.allstate.entities;

import com.allstate.enums.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="trips")
public class Trip {
    private int id;
    private int version;
    private double duration;
    private Timestamp startTime;
    private Timestamp stopTime;
    private Car car;
    private Passenger passenger;
    private Driver driver;
    private City city;
    private int distance;
    private int tip;
    private double cost;
    private double totalCost;
    private Review driverReview;
    private String driverReviewText;
    private Review passengerReview;
    private String passengerReviewText;
    private Date created;
    private Date modified;

    public Trip() {
    }

    public Trip(double duration, Timestamp startTime, Timestamp stopTime, Car car, Passenger passenger, Driver driver, City city, int distance, double cost, double totalCost) {
        this.duration = duration;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.car = car;
        this.passenger = passenger;
        this.driver = driver;
        this.city = city;
        this.distance = distance;
        this.cost = cost;
        this.totalCost = totalCost;
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
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @NotNull
    public Timestamp getStartTime() {
        return startTime;
    }
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @NotNull
    public Timestamp getStopTime() {
        return stopTime;
    }
    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    @NotNull
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @NotNull
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @NotNull
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
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

    //Trip to Car mapping
    @ManyToOne
    @JoinColumn(name="car_id")
    @JsonIgnore
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    //Trip to Passenger mapping
    @ManyToOne
    @JoinColumn(name="passenger_id")
    @JsonIgnore
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    //Trip to Driver mapping
    @ManyToOne
    @JoinColumn(name="driver_id")
    @JsonIgnore
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    //Trip to City mapping
    @ManyToOne
    @JoinColumn(name="city_id")
    @JsonIgnore
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
}
