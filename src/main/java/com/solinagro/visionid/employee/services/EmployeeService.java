package com.solinagro.visionid.employee.services;

import com.solinagro.visionid.employee.models.Employee;
import com.solinagro.visionid.employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id) {

        if (id == null) {
            return null;
        }

        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
