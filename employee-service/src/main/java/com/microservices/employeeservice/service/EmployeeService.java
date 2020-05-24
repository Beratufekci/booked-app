package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(String id,EmployeeDto employeeDto);

    Boolean delete(String id);

    EmployeeDto getById(String id);

    List<EmployeeDto> getAll();

}
