package com.crud.carRental.repository;

import com.crud.carRental.domain.ReservationChanges;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationChangesRepository extends CrudRepository<ReservationChanges, Long> {
}
