<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Unsuccessful</title>
</head>
<body>
<h2>Log In Unsuccessful, Try Again</h2>
<form action="getInformation" method="get">  
      Customer Name:<input type="text" name="cName"/><br/><br/>  
      Customer Password:<input type="text" name="cPassword"/><br/><br/>  
		<br/><br/>  
		<input type="submit"/>  
</form> 
<input type=button onClick="parent.location='index.jsp'"
 value='GO back to Log IN page'> <br/><br/> 
</body>
</html>