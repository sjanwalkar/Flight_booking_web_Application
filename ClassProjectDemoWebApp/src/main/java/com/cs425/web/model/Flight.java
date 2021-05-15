package com.cs425.web.model;

public class Flight {
	
	private String airline_code;
	private String flight_no;
	private String date;
	private String dep_airport;
	private String dep_time;
	private String arr_airport;
	private String arr_time;
	private int max_seat_firstclass;
	private int max_seat_economy;
	private int length_of_flight;
	private String booking_type;
	private int bonus_miles;
	private String c_emailid;
	private String firstclass_price;
	private String economy_price;
	
	public void setAirline_code(String airlinecode) {
		this.airline_code = airlinecode;
	}
	
	public String getAirline_code () {
		return this.airline_code;
	}
	
	public void setFlight_no (String flightno) {
		this.flight_no = flightno;
	}
	
	public String getFlight_no () {
		return this.flight_no;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDep_airport(String dep_airport) {
		this.dep_airport = dep_airport;
	}
	
	public String getDep_airport() {
		return this.dep_airport;
	}
	
	public void setDep_time(String deptime) {
		this.dep_time = deptime;
	}
	
	public String getDep_time() {
		return this.dep_time;
	}
	
	public void setArr_time(String arrtime) {
		this.arr_time = arrtime;
	}
	
	public String getArr_time() {
		return this.arr_time;
	}
	
	public void setArr_airport(String arrairport) {
		this.arr_airport = arrairport;
	}
	
	public String getArr_airport() {
		return this.arr_airport;
	}
	
	public void setMax_seat_firstclass(int firstclassseat) {
		this.max_seat_firstclass = firstclassseat;
	}
	
	public int getMax_seat_firstclass() {
		return this.max_seat_firstclass;
	}
	
	public void setMax_seat_economy(int economyseat) {
		this.max_seat_economy = economyseat;
	}
	
	public int getMax_seat_economy() {
		return this.max_seat_economy;
	}
	
	public void setLength_of_flight (int flightlength) {
		this.length_of_flight = flightlength;
	}
	
	public int getLength_of_flight() {
		return this.length_of_flight;
	}
	
	public void setBooking_type(String bookingtype) {
		this.booking_type = bookingtype;
	}
	
	public String getBooking_type() {
		return this.booking_type;
	}

	public void setBonus_miles(int bonusmiles){
		this.bonus_miles = bonusmiles;
	}
	
	public int getBonus_miles() {
		return this.bonus_miles;
	}
	
	public void setC_emailid(String cemailid) {
		this.c_emailid = cemailid;
	}
	
	public String getC_emailid() {
		return this.c_emailid;
	}

	public void setFirstclass_price (String firstclassprice) {
		this.firstclass_price = firstclassprice;
	}
	
	public String getFirstclass_price() {
		return this.firstclass_price;
	}
	
	public void setEconomy_price (String economyprice) {
		this.economy_price = economyprice;
	}
	
	public String getEconomy_pric410e() {
		return this.economy_price;
	}
	
	public String toString() {
		return "Airline Code : "+this.airline_code +"Flight No : "+this.flight_no +"Date : "+this.date +" Departure Airport : "+this.dep_airport +"Departure Time : "+this.dep_time +" Arrival Airport : "
+this.arr_airport +" Arrival Time : " +this.arr_time +"Available Seats in Economy : " +this.max_seat_economy +" Economy Price : "+this.economy_price + " Available seats in First Class : "+this.max_seat_firstclass +" First Class Price : "+this.firstclass_price;	}
}
