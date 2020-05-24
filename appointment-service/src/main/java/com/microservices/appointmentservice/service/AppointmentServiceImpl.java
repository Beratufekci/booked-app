package com.microservices.appointmentservice.service;

import com.microservices.appointmentservice.dto.AppointmentDto;
import com.microservices.appointmentservice.entity.Appointment;
import com.microservices.appointmentservice.repository.AppointmentRepository;
import com.microservices.CustomerServiceClient;
import com.microservices.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    CustomerServiceClient customerServiceClient;

    @Autowired
    ModelMapper modelMapper;



    @Transactional
    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {

        String name = "";
        Appointment appointment = modelMapper.map(appointmentDto,Appointment.class);

        ResponseEntity<CustomerDto> customerDto =
                                 customerServiceClient.get(appointmentDto.getCustomerId());

        if (customerDto != null){
            name = customerDto.getBody().getName();
        }

        /**
         * TicketDto assigne Id  customer verileri çekiyor.
         */



        appointmentRepository.save(appointment);

        List<Object> list = Arrays.asList(name,appointment);

        return modelMapper.map(list,AppointmentDto.class);
    }

    @Transactional
    @Override
    public AppointmentDto update(String id, AppointmentDto appointmentDto) {

        /*Optional<Appointment> employee =
                Optional.ofNullable(appointmentRepository.findById(id)
                        .orElseThrow(IllegalArgumentException::new));



        appointmentRepository.save(updatedAppointment);

        return modelMapper.map(updatedAppointment,AppointmentDto.class);*/
        return null;
    }

    @Override
    public Boolean delete(String id) {

        this.getById(id);

        appointmentRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public AppointmentDto getById(String id) {

        Appointment appointment = appointmentRepository.findById(id).get();

        if (appointment == null)
            throw new IllegalArgumentException("appointment cannot  found!");


        return modelMapper.map(appointment,AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> getAll() {

        List<Appointment> appointmentList = appointmentRepository.findAll();

        List<AppointmentDto> appointmentDtoList =
                Arrays.asList(modelMapper.map(appointmentList,AppointmentDto[].class));

        return appointmentDtoList;
    }
}
