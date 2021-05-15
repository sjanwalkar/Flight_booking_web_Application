package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cs425.web.model.Customer;

public class CustomerDao {

	static String PREVEMAILID;
	
    final String url = "jdbc:postgresql://localhost:5432/CS425project";
	final String user = "postgres";
	final String password = "Mukti1411$";//"<add your password>";

	private void setEmailid(String cEmailid) {
		 this.PREVEMAILID = cEmailid ;
	}
	
	public String getEmailid() {
		return this.PREVEMAILID;
	}
	
	public Customer getCustomerName(String cName, String cPassword) {
		
		   
		 String mySQL = "SELECT c_name, c_emailid, home_airport "
        		+ "FROM customer "
        		+ "WHERE c_name = ? AND password = ?";
        
		Customer ob1 = new Customer();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
	 			
	 		pStmt.setString(1, cName.trim());
	 		pStmt.setString(2, cPassword.trim());
	 		
            ResultSet rs = pStmt.executeQuery();
            
            while (rs.next()) {
            	/* Retrieves the value of the designated column in the current row 
            	   of this ResultSet object as a String in the Java programming language.
            	*/
            	ob1.setC_name(rs.getString("c_name")); 
            	ob1.setC_emailid(rs.getString("c_emailid"));
            	ob1.setHome_airport(rs.getString("home_airport"));
              
            	
            }
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
		
		String emailtemp = ob1.getC_emailid();
        this.setEmailid(emailtemp);
		
		return ob1;
	
	}
	
	public Customer getInfo(String yesorno, String cPassword) {
		
		 if(yesorno.equalsIgnoreCase("yes"))
		{
		 String mySQL = "SELECT c_name, c_emailid, home_airport "
       		+ "FROM customer "
       		+ "WHERE password = ?";
       
		Customer ob1 = new Customer();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
	 			
	 		pStmt.setString(1, cPassword.trim());
	 		
	 		
           ResultSet rs = pStmt.executeQuery();
           
           while (rs.next()) {
           	/* Retrieves the value of the designated column in the current row 
           	   of this ResultSet object as a String in the Java programming language.
           	*/
           	ob1.setC_name(rs.getString("c_name")); 
           	ob1.setC_emailid(rs.getString("c_emailid"));
           	ob1.setHome_airport(rs.getString("home_airport"));
               
           }
      }catch (SQLException e) {
   		 System.out.println(e.getMessage());
      }
		
		
		return ob1;
	} 
		else
			return null;
	}
	
	public int addCustomer(String cemailid, String cname, String cpassword) {
		
		String sql = "INSERT INTO customer(c_emailid, c_name, password)" +" VALUES(?,?,?)";
		
		int rs = 0;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, cemailid.trim());
            pstmt.setString(2, cname.trim());
            pstmt.setString(3, cpassword.trim());
            
             rs =   pstmt.executeUpdate();
          
		} catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return rs ;
		}
	
	public int addCreditcard(String ccno, String cctype, String bankname, Date cCEXPDATE, String nameoncard) {
		
		
		String sql = "INSERT INTO credit_card(credit_card_no, card_type, bank_name, expiry_date, name_on_card, c_emailid)" +" VALUES(?,?,?,?,?,?)";
		
		int rs = 0;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
			
			String c_emailid = this.PREVEMAILID;
			
			pstmt.setString(1, ccno.trim());
            pstmt.setString(2, cctype.trim());
            pstmt.setString(3, bankname.trim());
            pstmt.setDate(4, (cCEXPDATE));
            pstmt.setString(5, nameoncard.trim());
            pstmt.setString(6, c_emailid);
            
            pstmt.setDate(4, cCEXPDATE);
            
             rs =   pstmt.executeUpdate();
          
		} catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return rs ;
		}
	
	public int deleteCreditcard(String ccno) {
		
		String sql = "DELETE FROM credit_card WHERE credit_card_no = ?";
				
		int rs = 0;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, ccno.trim());
			
			rs = pstmt.executeUpdate();
		}	 catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	
public int modifyCreditcard(String ccno, String ctype, String bankname, Date expdate, String nameoncard) {
		
		String sql = "UPDATE credit_card SET  card_type = ?, bank_name = ?, expiry_date = ?, name_on_card = ? WHERE credit_card_no = ?";
		int rs = 0;		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(5, ccno.trim());
			pstmt.setString(1, ctype.trim());
			pstmt.setString(2, bankname.trim());
			pstmt.setDate(3, expdate);
			pstmt.setString(4, nameoncard.trim());
			
			rs = pstmt.executeUpdate();
		}	 catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}

	public int addAddress(String address) {
	
	
	String sql = "INSERT INTO address(address, c_emailid)" +" VALUES(?,?)";
	
	int rs = 0;
	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS)) {
		
		String c_emailid = this.PREVEMAILID;
		
		pstmt.setString(1, address.trim());
       
        pstmt.setString(2, c_emailid);
        
       rs =   pstmt.executeUpdate();
      
	} catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
	return rs ;
	}
	
public int deleteAddress(String address) {
		
		String sql = "DELETE FROM address WHERE address = ? ";
				
		int rs = 0;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, address.trim());
			
			rs = pstmt.executeUpdate();
		}	 catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	

}
	
	


