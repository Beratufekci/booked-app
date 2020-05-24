package com.microservices.appointmentservice.controller;

import com.microservices.appointmentservice.dto.AppointmentDto;
import com.microservices.appointmentservice.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<AppointmentDto> save(@RequestBody AppointmentDto appointmentDto){

        return ResponseEntity.ok(appointmentService.save(appointmentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> update(@PathVariable String id, @RequestBody AppointmentDto appointmentDto){

        return ResponseEntity.ok(appointmentService.update(id,appointmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){

        return ResponseEntity.ok(appointmentService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> findById(@PathVariable  String id){

        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> findAll(){

        return ResponseEntity.ok(appointmentService.getAll());
    }
}
