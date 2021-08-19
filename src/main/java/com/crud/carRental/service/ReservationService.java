package com.crud.carRental.service;

import com.crud.carRental.domain.Customer;
import com.crud.carRental.domain.Reservation;
import com.crud.carRental.domain.Vehicle;
import com.crud.carRental.domain.dto.ReservationDto;
import com.crud.carRental.exception.CustomerNotFoundException;
import com.crud.carRental.exception.ReservationNotFoundException;
import com.crud.carRental.exception.VehicleNotFoundException;
import com.crud.carRental.repository.CustomerRepository;
import com.crud.carRental.repository.ReservationRepository;
import com.crud.carRental.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;

    public ReservationService(ReservationRepository reservationRepository, CustomerRepository customerRepository, VehicleRepository vehicleRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Reservation getReservationById(Long id) throws ReservationNotFoundException {
        return reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationByCustomerId(Long id) {
        List<Reservation> reservationList = getAllReservations();
        return reservationList.stream()
                .filter(c -> c.getCustomer().getId().equals(id))
                .collect(Collectors.toList());
    }

    public Reservation createReservation(ReservationDto reservationDto) throws VehicleNotFoundException, CustomerNotFoundException {
        Customer customer = customerRepository.findById(reservationDto.getCustomerId()).orElseThrow(CustomerNotFoundException::new);
        Vehicle vehicle = vehicleRepository.findById(reservationDto.getCarId()).orElseThrow(VehicleNotFoundException::new);
        vehicle.setVehicleAvailability("Rented");

        Reservation reservation = new Reservation(
                reservationDto.getStartDate(),
                reservationDto.getReturnDate(),
                customer,
                vehicle);

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);
        reservation.getCustomer().getReservation().remove(reservation);
        reservation.getVehicle().getReservation().remove(reservation);
        reservation.getVehicle().setVehicleAvailability("Available");

        reservationRepository.deleteById(id);
    }

    public void updateTotalCost(Reservation reservation) {
        BigDecimal updateTotalCost = reservation.getVehicle().getDailyPrice().multiply(new BigDecimal(reservation.getDuration()));
        reservation.setTotalCost(updateTotalCost);
    }

}
