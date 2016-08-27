package com.byteclarity.ormtouchstone.model1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CUBICLE")
public class Cubicle  {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String building;
	
	@Column
	private String number;
	
	@OneToOne(optional=true, mappedBy="cubicle")
	private Employee employee;

    public Cubicle() {

	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}    
    
	@Override
    public String toString() {
        return String.format("Cubicle[id=%d, number=%s]", id, number);
    }
    

}
