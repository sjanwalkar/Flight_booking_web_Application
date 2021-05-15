package com.cs425.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.CustomerDao;
import com.cs425.web.dao.Book_flightDao;
/**
 * Servlet implementation class DeleteBookingIDCont
 */
public class DeleteBookingIDCont extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
/*    public DeleteBookingIDCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String BOOKINGID = request.getParameter("bookingid").toString();
		
		Book_flightDao od1  =  new Book_flightDao();
		
		int rs = od1.deleteBookingid(BOOKINGID);
		
		if(rs > 0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("BookingIDDeleted.jsp");
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
