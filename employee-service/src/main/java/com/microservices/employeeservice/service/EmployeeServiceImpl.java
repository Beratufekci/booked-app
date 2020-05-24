package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto,Employee.class);

        employeeRepository.save(employee);

        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Transactional
    @Override
    public EmployeeDto update(String id, EmployeeDto employeeDto) {

        Optional<Employee> employee =
                Optional.ofNullable(employeeRepository.findById(id)
                            .orElseThrow(IllegalArgumentException::new));

        Employee updatedEmployee = employee.map(e -> {

            e.setDepartment(employeeDto.getDepartment());
            e.setName(employeeDto.getName());
            e.setSurname(employeeDto.getSurname());
            e.setTitle(employeeDto.getTitle());

            return e;


        }).orElseThrow(IllegalArgumentException::new);

        employeeRepository.save(updatedEmployee);

        return modelMapper.map(updatedEmployee,EmployeeDto.class);

    }

    @Override
    public Boolean delete(String id) {

        this.getById(id);

        employeeRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public EmployeeDto getById(String id) {

        Employee employee = employeeRepository.findById(id).get();

        if (employee == null)
               throw new IllegalArgumentException("Employee cannot  found!");


        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAll() {

        List<Employee> employeeList = employeeRepository.findAll();

        List<EmployeeDto> dtoList =
                      Arrays.asList(modelMapper.map(employeeList,EmployeeDto[].class));

        return dtoList;
    }
}
