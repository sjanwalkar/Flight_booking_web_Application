<%@ page import="com.cs425.web.model.Flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search for Flights</title>
</head>
<h2>Search for Flights</h2>
<body>
 
 <form action="searchFlight" method="get">  
     
      Enter arrival destination : <input type="text" name="arr_dest"/><br/><br/> 
      Enter departure destination : <input type="text" name="dep_dest"/><br/><br/> 
      Enter Flight Date (yyyy-mm-dd) : <input type="text" name="flightdate"/><br/><br/> 
      Order By? Price / Length of flight : <input type="text" name="orderby"/><br/><br/> 
      Search For Return Flight? Enter yes/no : <input type="text" name="returnflight"/><br/><br/> 
      <br/>
		<input type="submit"/> 
		</form> 
		 <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
</body>
</html>