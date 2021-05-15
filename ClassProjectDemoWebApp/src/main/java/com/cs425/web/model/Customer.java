package com.cs425.web.model;

public class Customer {
	
	private String c_emailid;
	private String c_name;
	private int mileage;
	private String registration_in_mlg_program;
	private String home_airport;
	private int miles_count;
	private String password;
	private String iata_location_code;
	
	public String getC_emailid(){
		return this.c_emailid;
	}
	
	public void setC_emailid(String c_emailid) {
		this.c_emailid = c_emailid;
	}
	
	public String getC_name() {
		return this.c_name;
	}
	
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	public String getRegistration_mileage_program() {
		return this.registration_in_mlg_program;
	}
	
	public void setRegistration_mileage_program(String mileageprogram) {
		this.registration_in_mlg_program = mileageprogram;
	}
	
	public String getHome_airport() {
		return this.home_airport;
	}
	
	public void setHome_airport(String home_airport) {
		this.home_airport = home_airport;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Customer Name = "+this.c_name +", E-mail ID : "+this.c_emailid +", Home Airport : "+this.home_airport;
	}


}
