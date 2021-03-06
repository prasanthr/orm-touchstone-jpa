package com.byteclarity.ormtouchstone.model1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LazyInitializationException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.byteclarity.ormtouchstone.OrmTouchstoneApplication;
import com.byteclarity.ormtouchstone.model1.repo.CubicleRepository;
import com.byteclarity.ormtouchstone.model1.repo.DepartmentRepository;
import com.byteclarity.ormtouchstone.model1.repo.EmployeeRepository;
import com.byteclarity.ormtouchstone.model1.repo.ProjectRepository;


@SpringBootTest
//@DirtiesContext
public class FetchTests extends AbstractTestNGSpringContextTests {

	final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private CubicleRepository cubicleRepo;
    @Autowired
    private ProjectRepository projRepo;
    
    private Map<String, Long> idMap = new HashMap<>();
    
    @BeforeClass
    public void intBaseData() {
    	
    	Cubicle cub1 = new Cubicle();
    	cub1.setBuilding("building1");
    	cub1.setNumber("100");
    	cubicleRepo.save(cub1);
    	idMap.put("cub1", cub1.getId());
    	
    	Cubicle cub2 = new Cubicle();
    	cub2.setBuilding("building1");
    	cub2.setNumber("101");
    	cubicleRepo.save(cub2);
    	idMap.put("cub2", cub2.getId());
    	
    	Project proj1 = new Project("Hell's Kitchen Cleanup");
    	projRepo.save(proj1);
    	idMap.put("proj1", proj1.getId());
    	
    	Department dep1 = new Department();
    	dep1.setName("department1");
    	departmentRepo.save(dep1);
    	idMap.put("dep1", dep1.getId());
    	
    	Employee emp1 = new Employee("Matt Murdock");
    	emp1.setDepartment(dep1);
    	emp1.setCubicle(cub1);
    	emp1.addProject(proj1);
    	empRepo.save(emp1);
    	idMap.put("emp1", emp1.getId());
    	
    	Employee emp2 = new Employee("Foggy Nelson");
    	emp2.setDepartment(dep1);
    	emp2.setCubicle(cub2);    	
    	empRepo.save(emp2);
    	idMap.put("emp2", emp2.getId());
    	
    }
    

    //fetching employee
  	//one-to-one and many-to-one are eagerly fetched
    //many-to-many is lazily fetched.
  	//collections are lazily fetched
    @Test
	public void fetchEmployee() {
    	
    	Employee emp11 = empRepo.findOne(idMap.get("emp1"));
    	log.info("emp1="+emp11);
    	log.info("emp.dep="+emp11.getDepartment());
    	log.info("emp.cubicle="+emp11.getCubicle());
    	//log.info("emp.projects="+emp11.getProjects());
    	
    }
    
	//fetching department
	//department.employees one to many is lazily fetched
    @Test(expectedExceptions=LazyInitializationException.class)
    @SuppressWarnings("unused")
    public void fetchDepartment() {
    	Department dep1 = departmentRepo.findOne(idMap.get("dep1"));
    	log.info("dep1="+dep1);	
    	int count = dep1.getEmployees().size();
    }
    
    @Test
	public void fetchCubicle() {    	
    	Cubicle c1 = cubicleRepo.findOne(idMap.get("cub1"));
    	log.info("cube1="+c1);
    	log.info("emp.dep="+c1.getEmployee());
    }
   
    
    

}
