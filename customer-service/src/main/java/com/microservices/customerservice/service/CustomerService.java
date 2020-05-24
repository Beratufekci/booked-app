package com.microservices.customerservice.service;


import com.microservices.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(String id,CustomerDto customerDto);

    Boolean deleteCustomer(String id);

    CustomerDto getCustomerById(String id);

    List<CustomerDto> findAllCustomer();

}
