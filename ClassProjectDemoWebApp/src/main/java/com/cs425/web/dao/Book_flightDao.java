package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cs425.web.model.Book_flight;
import com.cs425.web.model.Customer;
import com.cs425.web.model.Flight;

public class Book_flightDao {

		final String url = "jdbc:postgresql://localhost:5432/CS425project";
		final String user = "postgres";
		final String password = "Mukti1411$";//"<add your password>";
		
		public Book_flight getBookingInfo(String yesorno, String cemailid) {
			
			 if(yesorno.equalsIgnoreCase("yes"))
			{
			 String mySQL = "SELECT booking_id, airline_code, flight_no, date "
	       		+ "FROM Book_flight NATURAL JOIN booking_id "
	       		+ "WHERE c_emailid = ?";
	       
			Book_flight ob1 = new Book_flight();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 		
			///	pStmt.setFetchSize(50);
				pStmt.setString(1, cemailid.trim());
		 		
	           ResultSet rs = pStmt.executeQuery();
	           
	           while (rs.next()) {
	           System.out.println("booking id: " +rs.getString(1) +"Airline code : "+rs.getString(2) +" Flight no :" +rs.getString(3) +" Date : "+rs.getString(4));
	           	ob1.setBooking_id(rs.getString("booking_id")); 
	           	ob1.setAirline_code(rs.getString("airline_code"));
	           	ob1.setFlight_no(rs.getString("flight_no"));
	           	ob1.setDate(rs.getString("date"));  
	       
	           }
	      }catch (SQLException e) {
	   		 System.out.println(e.getMessage());
	      }
			return ob1;
		} 
			else
				return null;
		}
		
		public int deleteBookingid(String bookingid) {
			
			int rs = 0;
			
			String sql = "UPDATE flight f SET max_seat_economy = (max_seat_economy + 1) where f.airline_code IN (SELECT airline_code FROM book_flight WHERE booking_id = ?)";
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
	                PreparedStatement pstmt = conn.prepareStatement(sql,
	                Statement.RETURN_GENERATED_KEYS)) {
				
				pstmt.setString(1, bookingid.trim());
	           
	             rs =   pstmt.executeUpdate();
	          
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			
			String sql1 = "DELETE FROM book_flight WHERE booking_id = ?";
					
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
	                PreparedStatement pstmt1 = conn.prepareStatement(sql1,
	                Statement.RETURN_GENERATED_KEYS)) 
			{
				pstmt1.setString(1, bookingid.trim());
				
				rs = pstmt1.executeUpdate();
			}	 catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
			
			String sql2 = "DELETE FROM booking_id where booking_id = ?";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
	                PreparedStatement pstmt2 = conn.prepareStatement(sql2,
	                Statement.RETURN_GENERATED_KEYS)) 
			{

				pstmt2.setString(1, bookingid.trim());
				
				rs = pstmt2.executeUpdate();
			}	 catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
			return rs;
		}
		
		public int addBooking(String bookingid, String airlinecode, String flightno, Date date, Date bookingdate, String seatclass, String creditcard) {
			
			int rs = 0;
			String mySQL = null;
			
			if(seatclass.equalsIgnoreCase("economy")){
			  mySQL = "SELECT max_seat_economy FROM flight WHERE airline_code = ? AND flight_no = ? AND date = ?";
			}
			else
			{
				 mySQL = "SELECT max_seat_firstclass FROM flight WHERE airline_code = ? AND flight_no = ? AND date = ?";
			}
				Flight ob1 = new Flight();

				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try (Connection conn = DriverManager.getConnection(url, user, password);
			 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
			 			
			 		pStmt.setString(1, airlinecode.trim());
			 		pStmt.setString(2, flightno.trim());
			 		pStmt.setDate(3, date);
			 		
		            ResultSet rs1 = pStmt.executeQuery();
		            
		            while (rs1.next()) {
		            	
		            	if(seatclass.equalsIgnoreCase("economy"))
		            	ob1.setMax_seat_economy(rs1.getInt("max_seat_economy")); 	
		            	else
		            		ob1.setMax_seat_economy(rs1.getInt("max_seat_firstclass")); 
		            }
		       }catch (SQLException e) {
		    		 System.out.println(e.getMessage());
		       }
			
			//System.out.println("Available seats"+ob1.getMax_seat_economy());
			
			if(ob1.getMax_seat_economy() > 0)
			{	
			CustomerDao temp = new CustomerDao();	
			String cemailid = temp.getEmailid();
			
			
			
			String sql2 = "INSERT INTO booking_id (booking_id, c_emailid, credit_card_no) " + "VALUES(?,?,?)";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
	                PreparedStatement pstmt = conn.prepareStatement(sql2,
	                Statement.RETURN_GENERATED_KEYS)) {
				
				pstmt.setString(1, bookingid.trim());
	            pstmt.setString(2, cemailid.trim());
	            pstmt.setString(3, creditcard.trim());
	            
	            rs =   pstmt.executeUpdate();
	          
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
String sql1 = "INSERT INTO book_flight(booking_id, airline_code, flight_no, date, booking_date, booking_type)" +" VALUES(?,?,?,?,?,?)";
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
	                PreparedStatement pstmt = conn.prepareStatement(sql1,
	                Statement.RETURN_GENERATED_KEYS)) {
				
				pstmt.setString(1, bookingid.trim());
	            pstmt.setString(2, airlinecode.trim());
	            pstmt.setString(3, flightno.trim());
	            pstmt.setDate(4, date);
	            pstmt.setDate(5, bookingdate);
	            pstmt.setString(6, seatclass.trim());
	            
	            rs =   pstmt.executeUpdate();
	          
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			
			
			String sql3 = null;
			
			if(seatclass.equalsIgnoreCase("Economy")) 
				 sql3 = "UPDATE flight SET max_seat_economy = (max_seat_economy - 1) WHERE airline_code = ? AND flight_no = ? AND date = ?";
			else
				sql3 = "UPDATE flight SET max_seat_firstclass = (max_seat_firstclass - 1) WHERE airline_code = ? AND flight_no = ? AND date = ?";
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
	                PreparedStatement pstmt = conn.prepareStatement(sql3,
	                Statement.RETURN_GENERATED_KEYS)) {
			
				pstmt.setString(1, airlinecode.trim());
				pstmt.setString(2, flightno.trim());
				pstmt.setDate(3, date);
				
	            rs = pstmt.executeUpdate();
	          
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			}
			else
			{
				rs = 0;
			}
			return rs ;
			}
		}	

