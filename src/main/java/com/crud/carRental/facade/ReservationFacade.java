package com.crud.carRental.facade;

import com.crud.carRental.domain.Reservation;
import com.crud.carRental.domain.dto.ReservationDto;
import com.crud.carRental.exception.CustomerNotFoundException;
import com.crud.carRental.exception.ReservationNotFoundException;
import com.crud.carRental.exception.VehicleNotFoundException;
import com.crud.carRental.mapper.ReservationMapper;
import com.crud.carRental.repository.ReservationRepository;
import com.crud.carRental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReservationFacade {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationFacade(ReservationService reservationService, ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public Reservation getReservationById(Long id) throws ReservationNotFoundException {
        return reservationMapper.mapToReservationDto(reservationService.getReservationById(id));
    }

    public List<Reservation> getAllReservations() {
        return reservationMapper.mapToReservationDtoList(reservationService.getAllReservations());
    }

    public Reservation createReservation(ReservationDto reservationDto) throws CustomerNotFoundException, VehicleNotFoundException {
        Reservation createdReservation = reservationService.createReservation(reservationDto);
        return reservationMapper.mapToReservationDto(createdReservation);
    }

    public List<Reservation> getReservationsByUserId(Long id) {
        return reservationMapper.mapToReservationDtoList(reservationService.getReservationByCustomerId(id));
    }

    public void deleteReservation (Long id) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);
        reservationService.deleteReservation(id);
    }

}
