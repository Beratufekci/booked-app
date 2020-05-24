package com.microservices.placeservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
@Table(name = "place")
@Entity
public class Place  extends BaseEntity{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Setter
    @Column(name = "place_name")
    private String placeName;

    @Setter
    @Column(name = "address")
    private String address;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "place_type")
    private PlaceType placeType;

    @Setter
    @Column(name = "phone_number")
    private String phoneNumber;

    @Setter
    @Column(name = "employee_id")
    private String employeeId;

    @Setter
    @Column(name = "capacity")
    private Integer capacity;

}
