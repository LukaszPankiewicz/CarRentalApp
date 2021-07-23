package com.crud.carRental.repository;

import com.crud.carRental.domain.VehicleStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusRepository extends CrudRepository<VehicleStatus, Long> {
}
