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
    private VehicleLocation vehicleLocation;
    private VehicleStatus vehicleStatus;
    private List<Reservation> reservation;
    private List<VehicleParam> vehicleParams;

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

    @ManyToOne
    @JoinColumn(name = "VEHICLELOCATION_ID")
    public VehicleLocation getVehicleLocation() {
        return vehicleLocation;
    }

    @ManyToOne
    @JoinColumn(name = "VEHICLESTATUS_ID")
    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
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

    public void setVehicleLocation(VehicleLocation vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
