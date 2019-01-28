package com.example.demo;

public class People {
	private String SSN;
	private String name;
	private String DOB;
	
	public People() {

	}
	
	public People(String sSN, String name, String dOB) {
		super();
		SSN = sSN;
		this.name = name;
		DOB = dOB;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}

}
