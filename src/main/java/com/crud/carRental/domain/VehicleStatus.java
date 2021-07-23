package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VEHICLESTATUS")
public class VehicleStatus {

    private Long id;
    private String vehicleAvailability;
    private String description;
    private List<Vehicle> vehicleList;

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "VEHICLEAVAILABILITY")
    public String getVehicleAvailability() {
        return vehicleAvailability;
    }

    @NonNull
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
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

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleAvailability(String vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
