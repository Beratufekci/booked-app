package com.microservices.employeeservice.dto;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private String id;

    private String name;

    private String surname;

    private String title;

    private String department;

}
