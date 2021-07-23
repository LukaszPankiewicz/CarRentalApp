package com.crud.carRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String login;
    private String password;
    private Date birthDate;
    private int pesel;
    private List<Reservation> reservation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    @NonNull
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @NonNull
    @Column(name = "PHONENUMBER")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    @NonNull
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    @NonNull
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @NonNull
    @Column(name = "BIRTHDATE")
    public Date getBirthDate() {
        return birthDate;
    }

    @NonNull
    @Column(name = "PESEL")
    public int getPesel() {
        return pesel;
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

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }
}
