package com.microservices.customerservice.controller;


import com.microservices.dto.CustomerDto;
import com.microservices.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){

        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String id,@RequestBody CustomerDto customerDto){

        return ResponseEntity.ok(customerService.updateCustomer(id,customerDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable String id){

        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id){

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomer(){

        return ResponseEntity.ok(customerService.findAllCustomer());
    }

}
