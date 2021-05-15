<html>
<body>

<h2>Add Credit Card</h2>
	<form action="modifyCreditcarddetails" method="get">  
	 Credit Card Number: <input type="text" name="newCCNo"/><br/><br/>  
     Credit Card Type:   <input type="text" name="newCCType"/><br/><br/>  
     Bank Name:          <input type="text" name="newBankname"/><br/><br/>  
     Exp. Date: (mm-dd-yyyy)         <input type="text" name="newExpirydate"/><br/><br/>  
     Name on Card:       <input type="text" name="newNameoncard"/><br/><br/>  
	<br/>
		<h2>Make Sure No Details shall be missing</h2> 
		<input type="submit"/>  		
</form>  
<h2>click to go back</h2>
<body>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
</body>
</body>
</html>