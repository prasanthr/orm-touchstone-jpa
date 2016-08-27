package com.byteclarity.ormtouchstone.model1;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	//default fetch-type is LAZY
	@ElementCollection
	private Map<Integer, String> perfRanks;
	
	//default fetch-type is LAZY
	@ElementCollection
	private List<String> comments;
	
	//default fetch-type is EAGER
	@OneToOne
	@JoinColumn(name="CUBICLE_ID")
	private Cubicle cubicle;
	
	//default fetch-type is EAGER
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
	//default fetch is LAZY
	@ManyToMany
	@JoinTable(name="EMPLOYEE_PROJECTS")
	private Set<Project> projects = new HashSet<>();
	

    protected Employee() {

	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cubicle getCubicle() {
		return cubicle;
	}

	public void setCubicle(Cubicle cubicle) {
		this.cubicle = cubicle;
	}
	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void addProject(Project proj) {
		projects.add(proj);
	}

	@Override
    public String toString() {
        return String.format("Employee[id=%d, name=%s]", id, name);
    }

}
