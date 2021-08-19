package com.crud.carRental.domain.dto;

import com.crud.carRental.domain.Customer;
import com.crud.carRental.domain.ReservationChanges;
import com.crud.carRental.domain.Vehicle;
import com.crud.carRental.domain.VehicleLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long id;
    private Date startDate;
    private Date returnDate;
    private BigDecimal reservationCost;
    private Long carId;
    private Long customerId;
    private VehicleLocation vehicleLocation;
    private List<ReservationChanges> reservationChanges;
}
