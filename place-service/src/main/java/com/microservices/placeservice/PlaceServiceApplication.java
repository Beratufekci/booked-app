package com.microservices.placeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlaceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlaceServiceApplication.class,args);
    }
}
