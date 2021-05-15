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
 * Servlet implementation class AddInformationController
 */
public class AddInformationController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
/*    public AddInformationController() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String CEMAILID = request.getParameter("newEmailid").toString();
		String CNAME = request.getParameter("newName").toString();
		String CPASSWORD = request.getParameter("newPassword").toString();
		
		
		CustomerDao od1  =  new CustomerDao();
		
		int rs = od1.addCustomer(CEMAILID, CNAME, CPASSWORD);
		
		if(rs > 0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("NewCustomerAdded.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
