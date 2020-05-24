package com.microservices.placeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {

    private String id;

    private String placeName;

    private String address;

    private String phoneNumber;

    private String employeeId;

    private Integer capacity;
}
