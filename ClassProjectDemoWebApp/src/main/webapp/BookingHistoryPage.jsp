<%@ page import="com.cs425.web.model.Book_flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Booking History</title>
</head>
<h2>Booking History </h2>
<body>
  <%
   Book_flight ob2 = (Book_flight) request.getAttribute("Book_flight");
   out.println(ob2);
  %>
  <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
 
 <h2> Enter Booking ID to cancel booking</h2>
  <form action="getBookingtodelete" method="get">  
      Enter Booking ID: <input type="text" name="bookingid"/><br/><br/> 
      <br/><br/>  
		<input type="submit"/> 
		</form> 
</body>
</html>