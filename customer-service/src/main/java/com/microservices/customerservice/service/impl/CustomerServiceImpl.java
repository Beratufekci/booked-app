package com.microservices.customerservice.service.impl;



import com.microservices.dto.CustomerDto;
import com.microservices.customerservice.entity.Customer;
import com.microservices.customerservice.repositroy.CustomerRepository;
import com.microservices.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto,Customer.class);

        Date now = new Date();

        customer.setCreatedDate(now);

        customerRepository.save(customer);

        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    @Transactional
    public CustomerDto updateCustomer(String id, CustomerDto customerDto) {

       // Assert.isNull(id,"Id cannot be null!");

        Optional<Customer> customer = customerRepository.findById(id);

      Customer updateCustomer =  customer.map(c->{
            c.setName(customerDto.getName());
            c.setSurname(customerDto.getSurname());
            c.setMail(customerDto.getMail());
            c.setPhoneNumber(customerDto.getPhoneNumber());
            return c;

        }).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(updateCustomer,CustomerDto.class);
    }

    @Override
    public Boolean deleteCustomer(String id) {

        //Assert.isNull(id,"Id cannot be null!");

        Customer customer = customerRepository.findById(id)
                                .orElseThrow(IllegalArgumentException::new);

        customerRepository.delete(customer);

        return Boolean.TRUE;
    }

    @Override
    public CustomerDto getCustomerById(String id) {

        if (id==null)
                throw new IllegalArgumentException("Id cannot be null");

        Customer customer = customerRepository.findById(id)
                                .orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public List<CustomerDto> findAllCustomer() {

      List<Customer> customerList =  customerRepository.findAll();

      List<CustomerDto> customerDtoList = Arrays.asList(modelMapper.map(customerList,CustomerDto[].class));

      return customerDtoList;
    }
}
