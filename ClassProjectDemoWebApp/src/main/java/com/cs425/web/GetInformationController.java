package com.cs425.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.CustomerDao;
import com.cs425.web.model.Customer;

/**
 * Servlet implementation class GetInformationController
 */
public class GetInformationController extends HttpServlet {
	
	String PREVPASSWORD;
	String PREVEMAILID;
	
	private void setPassword(String cPassword) {
		 this.PREVPASSWORD = cPassword;
	}
	
	private String getPassword() {
		return this.PREVPASSWORD;
	}
	
	private void setEmailid(String cEmailid) {
		 this.PREVEMAILID = cEmailid ;
	}
	
	public String getEmailid() {
		return this.PREVEMAILID;
	}
	
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 *//**
		 * @see HttpServlet#HttpServlet()
		 *//*
			 * public GetInformationController() { super(); // TODO Auto-generated
			 * constructor stub }
			 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String check = request.getParameter("cName");
		if(check != null) {
		
			String CNAME = request.getParameter("cName").toString();
			String CPASSWORD = request.getParameter("cPassword").toString();
			this.setPassword(CPASSWORD);
			
		//Servlet should only fetch and accept the request and no JDBC processing
		// Use Dao the take care of JDBC processing
		CustomerDao od1  =  new CustomerDao();
		
		Customer ob1 = od1.getCustomerName(CNAME, CPASSWORD);
		
		String cEmailid = ob1.getC_emailid();
		this.setEmailid(cEmailid);
		// To display the data, create a JSP file (e.g., ShowInstructor.jsp)
		
		if(ob1.getC_name() != null) {
		// To send the Instructor object ob1 to JSP file. (e.g., ShowInstructor.jsp) 
		request.setAttribute("Customer", ob1);  // fetch this attribute in the JSP file
		
		// To call JSP page that will display the data either using dispatcher or send redirect.
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		} else
		{
			RequestDispatcher rd = request.getRequestDispatcher("ShowLogInStatus.jsp");
			rd.forward(request, response);
		}
		
	}
		String check1 = request.getParameter("yesorno");
		
		if(check1 != null)
		{
			
			String yesno = request.getParameter("yesorno").toString();
			
			if(yesno.equalsIgnoreCase("yes")) {
			String PASSWORD = this.getPassword();
			//Servlet should only fetch and accept the request and no JDBC processing
			// Use Dao the take care of JDBC processing
			CustomerDao od1  =  new CustomerDao();
			
			Customer ob1 = od1.getInfo(yesno, PASSWORD);
		
			request.setAttribute("Customer", ob1);  // fetch this attribute in the JSP file
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowInfo.jsp");
			rd.forward(request, response);
			}
			else {
				String PASSWORD = this.getPassword();
				
				CustomerDao od1  =  new CustomerDao();
				
				Customer ob1 = od1.getInfo(yesno, PASSWORD);
				
				request.setAttribute("Customer", ob1);  

				RequestDispatcher rd = request.getRequestDispatcher("ShowGoodBye.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}
	
	
}
