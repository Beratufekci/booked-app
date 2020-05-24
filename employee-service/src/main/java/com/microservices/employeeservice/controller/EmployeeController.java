package com.microservices.employeeservice.controller;

import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){

        return ResponseEntity.ok(employeeService.save(employeeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable String id, @RequestBody EmployeeDto employeeDto){

        return ResponseEntity.ok(employeeService.update(id,employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){

        return ResponseEntity.ok(employeeService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable  String id){

        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(){

        return ResponseEntity.ok(employeeService.getAll());
    }
}
