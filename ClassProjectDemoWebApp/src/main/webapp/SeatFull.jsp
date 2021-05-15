<%@ page import="com.cs425.web.model.Book_flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Booking Done</title>
</head>
<h2>Flight Does Not have Any Seats Left, Try Other class or flight please</h2>
<body>
  
  <br/><br/>
   <input type=button onClick="parent.location='ShowSearchflight.jsp'"
 value='GO back to search flight'> <br/><br/>
 
 <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
 

</body>
</html>