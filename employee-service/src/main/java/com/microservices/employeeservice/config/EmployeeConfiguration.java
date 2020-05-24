package com.microservices.employeeservice.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.microservices")
public class EmployeeConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
