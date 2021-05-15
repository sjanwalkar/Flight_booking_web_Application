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
 
  <h2>Enter yes to See Your Booking History</h2>
  <form action="getBookingInformation" method="get">  
      Enter yes/no<input type="text" name="yesorno"/><br/><br/> 
      <br/><br/>  
		<input type="submit"/> 
		</form> 
		
		 <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
</body>
</html>