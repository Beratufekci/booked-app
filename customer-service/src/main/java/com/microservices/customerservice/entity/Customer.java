package com.microservices.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.temporal.Temporal;
import java.util.Date;
import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(value = "customer")
@ToString
public class Customer {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "name")
    private String name;

    @Setter
    @Column(value = "surname")
    private String surname;

    @Setter
    @Column(value = "mail")
    private String mail;

    @Setter
    @Column(value = "birth_date")
    private Date birthDate;

    @Setter
    @Column(value = "phone_number")
    private String phoneNumber;

    @Setter
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(value = "created_date")
    private Date createdDate;

    @Setter
    @Column(value = "is_active")
    private Boolean active;

}

