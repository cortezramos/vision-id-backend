package com.solinagro.visionid.employee.controllers;

import com.solinagro.visionid.employee.models.Employee;
import com.solinagro.visionid.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vision-id/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getById/{id}")
    public Employee getEmployeeById(@PathVariable final Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
