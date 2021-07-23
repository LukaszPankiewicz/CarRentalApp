package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLEPARAM")
public class VehicleParam {

    private Long id;
    private String bodyType;
    private int yearOfProduction;
    private String fuelType;
    private int engineCapacity;
    private int power;
    private String gearBox;
    private int doorNumber;
    private int seatsNumber;
    private String color;
    private String description;
    private Vehicle vehicle;

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "BODYTYPE")
    public String getBodyType() {
        return bodyType;
    }

    @NonNull
    @Column(name = "YEAROFPRODUCTION")
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    @NonNull
    @Column(name = "FUELTYPE")
    public String getFuelType() {
        return fuelType;
    }

    @NonNull
    @Column(name = "ENGINECAPACITY")
    public int getEngineCapacity() {
        return engineCapacity;
    }

    @NonNull
    @Column(name = "POWER")
    public int getPower() {
        return power;
    }

    @NonNull
    @Column(name = "GEARBOX")
    public String getGearBox() {
        return gearBox;
    }

    @NonNull
    @Column(name = "DOORNUMBER")
    public int getDoorNumber() {
        return doorNumber;
    }

    @NonNull
    @Column(name = "SEATSNUMBER")
    public int getSeatsNumber() {
        return seatsNumber;
    }

    @NonNull
    @Column(name = "COLOR")
    public String getColor() {
        return color;
    }

    @NonNull
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
