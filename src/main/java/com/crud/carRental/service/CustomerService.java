package com.crud.carRental.service;

import com.crud.carRental.domain.Customer;
import com.crud.carRental.exception.CustomerNotFoundException;
import com.crud.carRental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerRepository.findByEmail(email).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer getCustomerByPhoneNumber(int phoneNumber) throws CustomerNotFoundException {
        return customerRepository.findByPhoneNumber(phoneNumber).orElseThrow(CustomerNotFoundException::new);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Boolean doesCustomerHaveReservations(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        return customer.getReservation().isEmpty();
    }

    public Boolean isCustomerAlreadyRegistered(String email) {
        return customerRepository.existsByEmail(email);
    }

}
