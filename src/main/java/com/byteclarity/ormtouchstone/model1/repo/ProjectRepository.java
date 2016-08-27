package com.byteclarity.ormtouchstone.model1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.byteclarity.ormtouchstone.model1.Employee;
import com.byteclarity.ormtouchstone.model1.Project;

/**
 * 
 * @author Prasanth Ramachandran
 * 
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
		

}
