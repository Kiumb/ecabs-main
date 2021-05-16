package com.ecabs.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecabs.root.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
