package com.crud.carRental.repository;

import com.crud.carRental.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Long aLong);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByPhoneNumber(int phoneNumber);

    Boolean existsByEmail(String email);
}
