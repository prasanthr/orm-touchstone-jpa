package com.byteclarity.ormtouchstone.model1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*
 * One Department has many employees
 * 
 */

@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	//default fetch-type is LAZY
	@OneToMany (mappedBy="department")
	private List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
    public String toString() {
        return String.format("Department[id=%d, name=%s]", id, name);
    }
	
}
