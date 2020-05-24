package com.microservices.appointmentservice.dto;

import com.microservices.appointmentservice.entity.AppointmentStatus;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentDto {

    private String id;

    private String employeeId;

    private Date appointmentDate;

    private String placeId;

    private String customerId;

    private AppointmentStatus appointmentStatus;

    private String CustomerName;

}
