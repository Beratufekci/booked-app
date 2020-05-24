package com.microservices.appointmentservice.config;


import com.microservices.CustomerServiceClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.microservices")
@ComponentScan("com.microservices")
public class AppointmentConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
