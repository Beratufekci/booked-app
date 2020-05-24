package com.microservices.placeservice.entity.elastic;

import com.microservices.placeservice.entity.PlaceType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = { "id" } )
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "place")
public class EsPlace implements Serializable {

    @Id
    private String id;

    private String placeName;

    private String address;

    private PlaceType placeType;

    private String phoneNumber;

    private String employeeId;

    private Integer capacity;
}
