package com.crud.carRental.mapper;

import com.crud.carRental.domain.Customer;
import com.crud.carRental.domain.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerMapper {

    public Customer mapToCustomer(final CustomerDto customerDto) {
        return new Customer(
                customerDto.getEmail(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getPhoneNumber(),
                customerDto.getLogin(),
                customerDto.getPassword()
        );
    }

    public CustomerDto mapToCustomerDto(final Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getLogin(),
                customer.getPassword(),
                customer.getReservation()
        );
    }

    public List<CustomerDto> mapToCustomerDtoList(final List<Customer> customerList) {
        return customerList.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

}
