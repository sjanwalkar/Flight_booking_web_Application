<%@ page import="com.cs425.web.model.Flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Flight Result</title>
</head>
<h2>Flight Search History</h2>
<body>
  <%
   Flight ob2 = (Flight) request.getAttribute("Flight");
   out.println(ob2);
  %>
  <br/><br/>
  
  <h2>Book Flight</h2>
  <form action="bookFlight" method="get">  
     
      Enter Booking ID : <input type="text" name="bookingid"/><br/><br/> 
      Enter Airline Code : <input type="text" name="airlinecode"/><br/><br/> 
      Enter Flight No : <input type="text" name="flightno"/><br/><br/> 
      Enter Date : <input type="text" name="date"/><br/><br/>
      Enter Booking Date : <input type="text" name="bookingdate"/><br/><br/>
      Enter Seat Type (Economy / First class) : <input type="text" name="seatclass"/><br/><br/>
      Enter Credit Card No. : <input type="text" name="creditcardno"/><br/><br/>
      <br/><br/>  
		<input type="submit"/> 
		</form> 
  
 <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
 

</body>
</html>