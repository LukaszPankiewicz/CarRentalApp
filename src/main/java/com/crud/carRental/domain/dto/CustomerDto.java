package com.crud.carRental.domain.dto;

import com.crud.carRental.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String login;
    private String password;
    private List<Reservation> reservation;

}
