package com.crud.carRental.repository;

import com.crud.carRental.domain.VehicleParam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleParamRepository extends CrudRepository<VehicleParam, Long> {
}
