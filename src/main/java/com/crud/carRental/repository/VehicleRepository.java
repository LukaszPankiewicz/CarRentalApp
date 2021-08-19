package com.crud.carRental.repository;

import com.crud.carRental.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    @Override
    List<Vehicle> findAll();

    List<Vehicle> findByModel(String model);

    List<Vehicle> findByDailyPrice(BigDecimal dailyPrice);

    Optional<Vehicle> findByRegistration(String registration);
}
