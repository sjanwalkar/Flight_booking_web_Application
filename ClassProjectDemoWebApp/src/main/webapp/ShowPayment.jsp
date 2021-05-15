<html>
<body>

<h2>Add Credit Card</h2>
	<form action="addCreditcarddetails" method="get">  
	 Credit Card Number: <input type="text" name="newCCNo"/><br/><br/>  
     Credit Card Type:   <input type="text" name="newCCType"/><br/><br/>  
     Bank Name:          <input type="text" name="newBankname"/><br/><br/>  
     Exp. Date: (mm-dd-yyyy)         <input type="text" name="newExpirydate"/><br/><br/>  
     Name on Card:       <input type="text" name="newNameoncard"/><br/>
	
		<h3>Make Sure No Details shall be missing</h3> 
		<input type="submit"/>  
		
		
</form>  
<h2>Delete Credit Card</h2>
<form action="deleteCreditcarddetails" method="get">  
	 Credit Card Number: <input type="text" name="newCCNo"/><br/>
	 
		<h3>Are you sure to delete this Credit Card?</h3> 
		<input type="submit"/>   
	 </form>
	 
	 <h2>Modify Credit Card</h2>
	 
	 <input type=button onClick="parent.location='CreditcardModifier.jsp'"
 value='Modify'> <br/><br/>
 
 <br/><br/>
 <input type=button onClick="parent.location='ShowCustomer.jsp'"
 value='GO back to Account Details'> <br/><br/>
</body>
</html>
