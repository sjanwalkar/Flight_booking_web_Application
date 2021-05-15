package com.cs425.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.Book_flightDao;
import com.cs425.web.dao.CustomerDao;
import com.cs425.web.model.Book_flight;
import com.cs425.web.model.Customer;

/**
 * Servlet implementation class GetBookingInformationCont
 */
public class GetBookingInformationCont extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  /*  public GetBookingInformationCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String BOOKINGINFO = request.getParameter("yesorno").toString();
	
		if(BOOKINGINFO.equalsIgnoreCase("yes")) 
		{
		CustomerDao c1 = new CustomerDao();
		String CEMAILID = c1.getEmailid();
		CEMAILID.trim();
		
		Book_flightDao od1  =  new Book_flightDao();
		
		Book_flight ob1 = od1.getBookingInfo(BOOKINGINFO, CEMAILID);
		
		request.setAttribute("Book_flight", ob1);  // fetch this attribute in the JSP file
		
		RequestDispatcher rd = request.getRequestDispatcher("BookingHistoryPage.jsp");
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
