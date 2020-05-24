package com.microservices;


import com.microservices.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("customer-service")
public interface CustomerServiceClient {



    @RequestMapping("/customer/{id}")
    ResponseEntity<CustomerDto> get(@PathVariable("id") String id);
}
