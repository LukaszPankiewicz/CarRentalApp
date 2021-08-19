package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    private Long id;
    private String registration;
    private String brand;
    private String model;
    private BigDecimal dailyPrice;
    private String vehicleAvailability;
    private VehicleLocation vehicleLocation;
    private List<Reservation> reservation;
    private List<VehicleParam> vehicleParams;

    public Vehicle(Long id, String registration, String brand, String model, BigDecimal dailyPrice, String vehicleAvailability, VehicleLocation vehicleLocation) {
        this.id = id;
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.dailyPrice = dailyPrice;
        this.vehicleAvailability = vehicleAvailability;
    }

    public Vehicle(Long id, String registration, String brand, String model, BigDecimal dailyPrice, String vehicleAvailability) {
    }

    public Vehicle(Long id, String registration, String brand, String model, BigDecimal dailyPrice, String vehicleAvailability, VehicleLocation vehicleLocation, List<Reservation> reservation, List<VehicleParam> vehicleParams) {

    }

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "REGISTRATION")
    public String getRegistration() {
        return registration;
    }

    @Column(name = "BRAND")
    public String getBrand() {
        return brand;
    }

    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    @Column(name = "DAILYPRICE")
    public BigDecimal getDailyPrice() {
        return dailyPrice;
    }

    @Column(name = "VEHICLEAVAILABILITY")
    public String getVehicleAvailability() {
        return vehicleAvailability;
    }

    @ManyToOne
    @JoinColumn(name = "VEHICLELOCATION_ID")
    public VehicleLocation getVehicleLocation() {
        return vehicleLocation;
    }


    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Reservation> getReservation() {
        return reservation;
    }

    @OneToMany(
            targetEntity = VehicleParam.class,
            mappedBy = "vehicleParam",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<VehicleParam> getVehicleParams() {
        return vehicleParams;
    }

    public void setVehicleParams(List<VehicleParam> vehicleParams) {
        this.vehicleParams = vehicleParams;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDailyPrice(BigDecimal dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public void setVehicleAvailability(String vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    public void setVehicleLocation(VehicleLocation vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

}
