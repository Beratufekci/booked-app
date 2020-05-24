package com.microservices.appointmentservice.service;

import com.microservices.appointmentservice.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    AppointmentDto save(AppointmentDto appointmentDto);

    AppointmentDto update(String id, AppointmentDto appointmentDto);

    Boolean delete(String id);

    AppointmentDto getById(String id);

    List<AppointmentDto> getAll();
}
