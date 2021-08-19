package com.crud.carRental.domain.dto;

import com.crud.carRental.domain.Reservation;
import com.crud.carRental.domain.VehicleLocation;
import com.crud.carRental.domain.VehicleParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private Long id;
    private String registration;
    private String brand;
    private String model;
    private BigDecimal dailyPrice;
    private String vehicleAvailability;
    private VehicleLocation vehicleLocation;
    private List<Reservation> reservation;
    private List<VehicleParam> vehicleParams;

}
