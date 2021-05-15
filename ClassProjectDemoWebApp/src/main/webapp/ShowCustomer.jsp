<%@ page import="com.cs425.web.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Account Information</title>
</head>
<h2>Welcome</h2>
<body>
  <input type=button onClick="parent.location='ShowPayment.jsp'"
 value='Credit Card Details'> <br/><br/>
 
  <input type=button onClick="parent.location='ShowSearchflight.jsp'"
 value='Search Flight'> <br/><br/>
 
  <input type=button onClick="parent.location='ShowBookingHistory.jsp'"
 value='Booking History'> <br/><br/>
 
  <input type=button onClick="parent.location='Address.jsp'"
 value='Address'> <br/><br/>
 
   <input type=button onClick="parent.location='ShowGoodBye.jsp'"
 value='Log Out'> <br/><br/>
</body>
</html>