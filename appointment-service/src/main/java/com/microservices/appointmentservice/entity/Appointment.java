package com.microservices.appointmentservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
@Document(collection  = "appointment")
public class Appointment {

    @Id
    private String id;

    private String employeeId;

    private Date appointmentDate;

    private String placeId;

    private String customerId;

    private AppointmentStatus appointmentStatus;

}
