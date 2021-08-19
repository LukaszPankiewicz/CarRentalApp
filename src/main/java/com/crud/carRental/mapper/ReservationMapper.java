package com.crud.carRental.mapper;

import com.crud.carRental.domain.Reservation;
import com.crud.carRental.domain.dto.ReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapper {

    public Reservation mapToReservation(final ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getStartDate(),
                reservationDto.getReturnDate(),
                reservationDto.getReservationCost()
        );
    }

    public Reservation mapToReservationDto(final Reservation reservation) {
        return new Reservation(
                reservation.getId(),
                reservation.getStartDate(),
                reservation.getReturnDate(),
                reservation.getReservationCost(),
                reservation.getCustomer(),
                reservation.getVehicle(),
                reservation.getReservationChanges(),
                reservation.getVehicleLocation()
        );
    }

    public List<Reservation> mapToReservationDtoList(final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(this::mapToReservationDto)
                .collect(Collectors.toList());
    }
}
