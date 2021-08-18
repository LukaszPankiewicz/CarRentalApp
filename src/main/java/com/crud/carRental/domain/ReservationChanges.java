package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESERVATIONCHANGES")
public class ReservationChanges {

    private Long id;
    private Date dateChange;
    private Long oldReservationId;
    private Long newReservationId;
    private Reservation reservation;

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "DATECHANGE")
    public Date getDateChange() {
        return dateChange;
    }

    @NonNull
    @Column(name = "OLDRESERVATIONID")
    public Long getOldReservationId() {
        return oldReservationId;
    }

    @NonNull
    @Column(name = "NEWRESERVATIONID")
    public Long getNewReservationId() {
        return newReservationId;
    }

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    public Reservation getReservation() {
        return reservation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateChange(Date dateChange) {
        this.dateChange = dateChange;
    }

    public void setOldReservationId(Long oldReservationId) {
        this.oldReservationId = oldReservationId;
    }

    public void setNewReservationId(Long newReservationId) {
        this.newReservationId = newReservationId;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
