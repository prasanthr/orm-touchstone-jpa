package com.byteclarity.ormtouchstone.model1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PROJECT")
public class Project  {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	@ManyToMany(mappedBy="projects")
	private Set<Employee> employees = new HashSet<>();

    public Project() {

	}
    
    public Project(String name) {
    	this.name = name;
   	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	
    @Override
    public String toString() {
        return String.format("Project[id=%d, name=%s]", id, name);
    }
}
