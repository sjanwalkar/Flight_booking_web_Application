package com.cs425.web.model;

public class Book_flight {

	private String booking_id;
	private String airline_code;
	private String flight_no;
	private String date;
	private String booking_date;
	
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	
	public String getBooking_id () {
		return this.booking_id;
	}
	
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
	
	public void setBooking_date (String bookdate) {
		this.booking_date = bookdate;
	}
	
	public String getBooking_date () {
		return this.booking_date;
	}
	
	public String toString () {
		return "Booking ID : "+this.booking_id +" Airline Code : " +this.airline_code +" Flight No. : " +this.flight_no +" Date : " +this.date;
	}
}
