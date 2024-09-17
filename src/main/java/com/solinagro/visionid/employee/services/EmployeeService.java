package com.solinagro.visionid.employee.services;

import com.solinagro.visionid.common.exceptions.VisionException;
import com.solinagro.visionid.employee.models.Employee;
import com.solinagro.visionid.employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) throws VisionException {

        if (employee == null) {
            throw new VisionException("Employee is null");
        }

        Employee employeeFound = employeeRepository.findByExternalId(employee.getExternalId()).orElse(null);

        if (employeeFound != null) {
            throw new VisionException("Empleado con id externo ya existe");
        }

        Employee employeeFoundByIdNumber = employeeRepository
                .findByDocumentIdentification(employee.getDocumentIdentification()).orElse(null);

        if (employeeFoundByIdNumber != null) {
            throw new VisionException("Empleado con número de identificación ya existe");
        }

        log.info("Se dio de alta a el empleado: {} con id externo: {} ", employee.getName(), employee.getExternalId());
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) throws VisionException {

        if (id == null) {
            throw new VisionException("Id enviado es nulo");
        }

        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee deleteEmployee(Long id) throws VisionException {
        if (id == null) {
            throw new VisionException("Id enviado es nulo");
        }

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            throw new VisionException("Empleado no encontrado, no se puede eliminar");
        }

        employeeRepository.delete(employee);

        log.info("Se eliminó a el empleado: {} con id externo: {} ", employee.getName(), employee.getExternalId());
        return employee;
    }

    public Employee updateEmployee(Employee employee) throws VisionException {
        if (employee == null) {
            throw new VisionException("Employee is null");
        }

        Employee employeeFound = employeeRepository.findById(employee.getId()).orElse(null);

        if (employeeFound == null) {
            throw new VisionException("Empleado no encontrado, no se puede actualizar");
        }

        Employee updatedEmployee = Employee.builder()
                .id(employeeFound.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .externalId(employeeFound.getExternalId())
                .documentIdentification(employeeFound.getDocumentIdentification())
                .build();

        log.info("Se actualizó a el empleado: {} con id externo: {} ", updatedEmployee.getName(), updatedEmployee.getExternalId());

        return employeeRepository.save(updatedEmployee);
    }

}
