package com.BootCampProject.BootCampProject.repository;

import com.BootCampProject.BootCampProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
