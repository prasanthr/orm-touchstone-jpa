package com.byteclarity.ormtouchstone.model1;

import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.byteclarity.ormtouchstone.OrmTouchstoneApplication;
import com.byteclarity.ormtouchstone.model1.repo.DepartmentRepository;
import com.byteclarity.ormtouchstone.model1.repo.EmployeeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrmTouchstoneApplication.class)
public class FetchTests {

	final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private DepartmentRepository departmentRepo;
    

    //fetching employee
  	//one-to-one and one-to-many are eagerly fetched
  	//collections are lazily fetched
    @Test
	public void fetchEmployee() {
    	
    	Employee emp1 = empRepo.findOne(1l);
    	log.info("emp1="+emp1);
    	log.info("emp.dep="+emp1.getDepartment());
    	log.info("emp.cubicle="+emp1.getCubicle());
    	
    }
    
	//fetching department
	//department.employees is lazily fetched
    @Test(expected=LazyInitializationException.class)
    //@Test
    @SuppressWarnings("unused")
    public void fetchDepartment() {
    	
    	Department dep1 = departmentRepo.findOne(1l);
    	log.info("dep1="+dep1);	
    	int count = dep1.getEmployees().size();
    }
    
    //fetching department
  	//department.employees is explicitly fetched using joint query
    @Test(expected=LazyInitializationException.class)
    public void fetchDepartmentJoin() {
      	
      	Department dep1 = departmentRepo.findOne(1l);
      	log.info("dep1="+dep1);	
      	log.info("dep.employees="+dep1.getEmployees());
      	
     }
    
    

}
