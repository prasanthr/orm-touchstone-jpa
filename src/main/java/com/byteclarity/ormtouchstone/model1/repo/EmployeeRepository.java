package com.byteclarity.ormtouchstone.model1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.byteclarity.ormtouchstone.model1.Employee;

/**
 * 
 * @author Prasanth Ramachandran
 * 
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
			

}
