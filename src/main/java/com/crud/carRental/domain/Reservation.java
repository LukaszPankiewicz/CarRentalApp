package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    private Long id;
    private Date startDate;
    private Date returnDate;
    private BigDecimal reservationCost;
    private Customer customer;
    private Vehicle vehicle;
    private VehicleLocation vehicleLocation;
    private List<ReservationChanges> reservationChanges;

    public Reservation(Long id, Date startDate, Date returnDate, BigDecimal reservationCost, Customer customer, Vehicle vehicle, List<ReservationChanges> reservationChanges, VehicleLocation vehicleLocation) {
        this.id = this.id;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.reservationCost = reservationCost;
    }

    public Reservation() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "STARTDATE")
    public Date getStartDate() {
        return startDate;
    }

    @NonNull
    @Column(name = "RETURNDATE")
    public Date getReturnDate() {
        return returnDate;
    }

    @NonNull
    @Column(name = "RESERVATIONCOST")
    public BigDecimal getReservationCost() {
        return reservationCost;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    public Customer getCustomer() {
        return customer;
    }

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID")
    public Vehicle getVehicle() {
        return vehicle;
    }

    @ManyToOne
    @JoinColumn(name = "VEHICLELOCATION_ID")
    public VehicleLocation getVehicleLocation() {
        return vehicleLocation;
    }

    @OneToMany(
            targetEntity = ReservationChanges.class,
            mappedBy = "reservationChanges",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<ReservationChanges> getReservationChanges() {
        return reservationChanges;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setReservationCost(BigDecimal reservationCost) {
        this.reservationCost = reservationCost;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVehicleLocation(VehicleLocation vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public void setReservationChanges(List<ReservationChanges> reservationChanges) {
        this.reservationChanges = reservationChanges;
    }
}
