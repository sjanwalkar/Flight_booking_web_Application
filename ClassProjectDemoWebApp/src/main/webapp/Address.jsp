<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address</title>

</head>
<h2>Add Address</h2>
<form action="addAddress" method="get">  
	 Enter Address: <input type="text" name="newAddress"/><br/><br/>  
		<input type="submit"/>  <br/><br/>		
</form>  
<body>
<h2>Delete Address</h2>
<form action="deleteAddress" method="get">  
	 Enter Address: <input type="text" name="newAddress"/><br/><br/>  
		<input type="submit"/>  		
</form>  

 <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
</body>
</html>