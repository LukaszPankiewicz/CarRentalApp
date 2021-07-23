package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VEHICLELOCATION")
public class VehicleLocation {

    private Long id;
    private String country;
    private String city;
    private String adress;
    private List<Reservation> reservationList;
    private List<Vehicle> vehicleList;

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    @NonNull
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @NonNull
    @Column(name = "ADRESS")
    public String getAdress() {
        return adress;
    }

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    @OneToMany(
            targetEntity = Vehicle.class,
            mappedBy = "vehicle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
