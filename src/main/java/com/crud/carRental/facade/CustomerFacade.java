package com.crud.carRental.facade;

import com.crud.carRental.domain.Customer;
import com.crud.carRental.domain.dto.CustomerDto;
import com.crud.carRental.exception.CustomerNotFoundException;
import com.crud.carRental.mapper.CustomerMapper;
import com.crud.carRental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerFacade {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerFacade(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerService.saveCustomer(customer);
        return customerMapper.mapToCustomerDto(savedCustomer);
    }

    public CustomerDto getCustomerById(Long id) throws CustomerNotFoundException {
        return customerMapper.mapToCustomerDto(customerService.getCustomerById(id));
    }

    public CustomerDto getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerMapper.mapToCustomerDto(customerService.getCustomerByEmail(email));
    }

    public CustomerDto getUserByPhoneNumber(int phoneNumber) throws CustomerNotFoundException {
        return customerMapper.mapToCustomerDto(customerService.getCustomerByPhoneNumber(phoneNumber));
    }

    public List<CustomerDto> getAllUsers() {
        return customerMapper.mapToCustomerDtoList(customerService.getAllCustomers());
    }

    public void deleteCustomer(Long id) throws CustomerNotFoundException {
        customerService.deleteCustomer(id);
    }

    public Boolean isCustomerAlreadyRegistered(String email) {
        return customerService.isCustomerAlreadyRegistered(email);
    }

    public Boolean doesCustomerHaveRents(Long id) throws CustomerNotFoundException {
        return customerService.doesCustomerHaveReservations(id);
    }
}
