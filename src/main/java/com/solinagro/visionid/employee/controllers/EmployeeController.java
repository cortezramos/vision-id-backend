package com.solinagro.visionid.employee.controllers;

import com.solinagro.visionid.common.exceptions.VisionException;
import com.solinagro.visionid.common.utilities.ApiResult;
import com.solinagro.visionid.common.wrapper.AbstractServiceWrapper;
import com.solinagro.visionid.employee.models.Employee;
import com.solinagro.visionid.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vision-id/employees")
@AllArgsConstructor
public class EmployeeController extends AbstractServiceWrapper {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<ApiResult> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return createResponseEntity(createApiResult("All employees found from db.", null, HttpStatus.OK, employees));
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResult> saveEmployee(@RequestBody final Employee employee) throws VisionException {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return createResponseEntity(createApiResult("Employee saved successfully.", null, HttpStatus.CREATED, savedEmployee));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ApiResult> getEmployeeById(@PathVariable final Long id) throws VisionException {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        return createResponseEntity(createApiResult("Employee found from db.", null, HttpStatus.OK, employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResult> deleteEmployee(@PathVariable final Long id) throws VisionException {
        Employee deletedEmployee = employeeService.deleteEmployee(id);
        return createResponseEntity(createApiResult("Employee deleted successfully.", null, HttpStatus.OK, deletedEmployee));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResult> updateEmployee(@RequestBody final Employee employee) throws VisionException {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return createResponseEntity(createApiResult("Employee updated successfully.", null, HttpStatus.OK, updatedEmployee));
    }

}
