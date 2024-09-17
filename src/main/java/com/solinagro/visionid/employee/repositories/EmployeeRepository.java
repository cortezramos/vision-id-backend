package com.solinagro.visionid.employee.repositories;

import com.solinagro.visionid.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByExternalId(Long externalId);

    Optional<Employee> findByDocumentIdentification(Long identificationNumber);

}
