package com.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eId;
	@NotNull(message = "Employee Name cannot be null")
	private String eName;
	@NotNull(message = "Employee salary cannot be null")
	@Positive(message = "Employee salary must be positive")
	private float eSal;
	@NotNull(message = "Employee position cannot be null")
	private String ePosition;
	
	//constructor

	public Employee() {
		super();
	}
	
	//constructor with parameters
	public Employee(Long eId, String eName, float eSal, String ePosition) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSal = eSal;
		this.ePosition = ePosition;
	}
	
	//getters and setters

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public float geteSal() {
		return eSal;
	}

	public void seteSal(float eSal) {
		this.eSal = eSal;
	}

	public String getePosition() {
		return ePosition;
	}

	public void setePosition(String ePosition) {
		this.ePosition = ePosition;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSal=" + eSal + ", ePosition=" + ePosition + "]";
	}

}
