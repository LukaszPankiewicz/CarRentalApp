package com.crud.carRental.service;

import com.crud.carRental.domain.Vehicle;
import com.crud.carRental.exception.VehicleNotFoundException;
import com.crud.carRental.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) throws VehicleNotFoundException {
        return vehicleRepository.findById(id).orElseThrow(VehicleNotFoundException::new);
    }

    public Vehicle getVehicleByRegistration(String registration) throws VehicleNotFoundException {
        return vehicleRepository.findByRegistration(registration).orElseThrow(VehicleNotFoundException::new);
    }

    public List<Vehicle> getVehicleByModel(String model) {
        return vehicleRepository.findByModel(model);
    }

    public List<Vehicle> getVehicleByDailyCost(BigDecimal dailyPrice) {
        return vehicleRepository.findByDailyPrice(dailyPrice);
    }

    public void deleteCar(Long id) {
        vehicleRepository.deleteById(id);
    }

}
