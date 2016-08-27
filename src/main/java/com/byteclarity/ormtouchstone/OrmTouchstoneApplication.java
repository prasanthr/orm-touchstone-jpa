package com.byteclarity.ormtouchstone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.byteclarity.ormtouchstone.model1.Cubicle;
import com.byteclarity.ormtouchstone.model1.Department;
import com.byteclarity.ormtouchstone.model1.Employee;
import com.byteclarity.ormtouchstone.model1.repo.CubicleRepository;
import com.byteclarity.ormtouchstone.model1.repo.DepartmentRepository;
import com.byteclarity.ormtouchstone.model1.repo.EmployeeRepository;


@SpringBootApplication
public class OrmTouchstoneApplication {
	
	@Bean
	CommandLineRunner init(EmployeeRepository empRepo,
			CubicleRepository cubicleRepo,
			DepartmentRepository departmentRepo) {
		
		return (evt) -> {
			
	    	/*Cubicle cub1 = new Cubicle();
	    	cub1.setBuilding("building1");
	    	cub1.setNumber("100");
	    	cubicleRepo.save(cub1);
	    	
	    	Cubicle cub2 = new Cubicle();
	    	cub2.setBuilding("building1");
	    	cub2.setNumber("101");
	    	cubicleRepo.save(cub2);
	    	
	    	
	    	Department dep1 = new Department();
	    	dep1.setName("department1");
	    	departmentRepo.save(dep1);
	    	
	    	Employee emp1 = new Employee("Matt Murdock");
	    	emp1.setDepartment(dep1);
	    	emp1.setCubicle(cub1);
	    	empRepo.save(emp1);
	    	
	    	Employee emp2 = new Employee("Matt Murdock");
	    	emp2.setDepartment(dep1);
	    	emp2.setCubicle(cub2);
	    	
	    	empRepo.save(emp2);*/
	    	
	    	
		};
	}
	
	public static void main(String[] args) {		
		SpringApplication.run(OrmTouchstoneApplication.class, args);
	}

}