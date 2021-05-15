package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import com.cs425.web.model.Customer;
import com.cs425.web.model.Flight;

public class FlightDao {

	final String url = "jdbc:postgresql://localhost:5432/CS425project";
	final String user = "postgres";
	final String password = "Mukti1411$";//"<add your password>";
	
	public Flight getSearchflight(String arrdest, String depdest, Date flightdate, String orderby, String returnflight) {
	
		String mySQL = null;
		
	 if(returnflight.equalsIgnoreCase("no")) {
	if(orderby.equalsIgnoreCase("price"))		
		mySQL = "SELECT airline_code, flight_no, date, dep_airport, dep_time, arr_airport, arr_time, max_seat_firstclass, max_seat_economy, firstclass_price, economy_price "
      		+ "FROM flight "
      		+ "WHERE arr_airport = ? AND dep_airport = ? AND date = ?"
      		+ "ORDER BY economy_price";
	else
		mySQL = "SELECT airline_code, flight_no, date, dep_airport, dep_time, arr_airport, arr_time, max_seat_firstclass, max_seat_economy, firstclass_price, economy_price "
	      		+ "FROM flight "
	      		+ "WHERE arr_airport = ? AND dep_airport = ? AND date = ?"
	      		+ "ORDER BY length_of_flight";
	
	
		Flight ob1 = new Flight();
		{
			 try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
	 	
			
	 		pStmt.setString(1, arrdest.trim());
	 		pStmt.setString(2, depdest.trim());
	 		pStmt.setDate(3, flightdate);
	 		
          ResultSet rs = pStmt.executeQuery();
          
          while (rs.next()) {
          	/* Retrieves the value of the designated column in the current row 
          	   of this ResultSet object as a String in the Java programming language.
          	*/
          	ob1.setAirline_code(rs.getString("airline_code"));
          	ob1.setFlight_no(rs.getString("flight_no"));
          	ob1.setDate(rs.getString("date"));
          	ob1.setDep_airport(rs.getString("dep_airport"));
          	ob1.setDep_time(rs.getString("dep_time"));
          	ob1.setArr_airport(rs.getString("arr_airport"));
            ob1.setArr_time(rs.getString("arr_time"));  
            ob1.setMax_seat_firstclass(rs.getInt("max_seat_firstclass"));
            ob1.setMax_seat_economy(rs.getInt("max_seat_economy"));
            ob1.setFirstclass_price(rs.getString("firstclass_price"));
            ob1.setEconomy_price(rs.getString("economy_price"));
            System.out.println(ob1);
          }
				
		 }catch (SQLException e) {
	   		 System.out.println(e.getMessage());
	      }
		}
			return ob1;
		} 
	 else {
		 if(orderby.equalsIgnoreCase("price"))		
				mySQL = "SELECT airline_code, flight_no, date, dep_airport, dep_time, arr_airport, arr_time, max_seat_firstclass, max_seat_economy, firstclass_price, economy_price "
		      		+ "FROM flight "
		      		+ "WHERE (arr_airport = ? AND dep_airport = ? AND date = ?) OR (arr_airport = ? AND dep_airport = ?)"
		      		+ "ORDER BY economy_price";
			else
				mySQL = "SELECT airline_code, flight_no, date, dep_airport, dep_time, arr_airport, arr_time, max_seat_firstclass, max_seat_economy, firstclass_price, economy_price "
			      		+ "FROM flight "
			      		+ "WHERE (arr_airport = ? AND dep_airport = ? AND date = ?) OR (arr_airport = ? AND dep_airport = ?)"
			      		+ "ORDER BY length_of_flight";
			
			
				Flight ob1 = new Flight();
				{
					 try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try (Connection conn = DriverManager.getConnection(url, user, password);
			 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
			 	
					
			 		pStmt.setString(1, arrdest.trim());
			 		pStmt.setString(2, depdest.trim());
			 		pStmt.setDate(3, flightdate);
			 		pStmt.setString(5, arrdest.trim());
			 		pStmt.setString(4, depdest.trim());
		          ResultSet rs = pStmt.executeQuery();
		          
		          while (rs.next()) {
		          	/* Retrieves the value of the designated column in the current row 
		          	   of this ResultSet object as a String in the Java programming language.
		          	*/
		          	ob1.setAirline_code(rs.getString("airline_code"));
		          	ob1.setFlight_no(rs.getString("flight_no"));
		          	ob1.setDate(rs.getString("date"));
		          	ob1.setDep_airport(rs.getString("dep_airport"));
		          	ob1.setDep_time(rs.getString("dep_time"));
		          	ob1.setArr_airport(rs.getString("arr_airport"));
		            ob1.setArr_time(rs.getString("arr_time"));  
		            ob1.setMax_seat_firstclass(rs.getInt("max_seat_firstclass"));
		            ob1.setMax_seat_economy(rs.getInt("max_seat_economy"));
		            ob1.setFirstclass_price(rs.getString("firstclass_price"));
		            ob1.setEconomy_price(rs.getString("economy_price"));
		            System.out.println(ob1);
		          }
						
				 }catch (SQLException e) {
			   		 System.out.println(e.getMessage());
			      }
				}
					return ob1;
	 }
		}
 
}
