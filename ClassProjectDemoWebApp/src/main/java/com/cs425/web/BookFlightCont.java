package com.cs425.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.Book_flightDao;
import com.cs425.web.dao.CustomerDao;

/**
 * Servlet implementation class BookFlightCont
 */
public class BookFlightCont extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 /*   public BookFlightCont() {
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
		String AIRLINECODE = request.getParameter("airlinecode").toString();
		String FLIGHTNO = request.getParameter("flightno").toString();
		String Dateflight = request.getParameter("date").toString();
		String Bookingdate = request.getParameter("bookingdate").toString();
		String SEATCLASS = request.getParameter("seatclass").toString();
		String CREDITCARD = request.getParameter("creditcardno").toString();
		
		Date DATEFLIGHT = Date.valueOf(Dateflight);
		Date BOOKINGDATE = Date.valueOf(Bookingdate);
		
		Book_flightDao od1  =  new Book_flightDao();
			
			int rs = od1.addBooking(BOOKINGID, AIRLINECODE, FLIGHTNO, DATEFLIGHT, BOOKINGDATE, SEATCLASS, CREDITCARD);
			
			if(rs > 0)
			{	
				request.setAttribute("Book_flight", od1); // check
					RequestDispatcher rd = request.getRequestDispatcher("BookingDone.jsp");
					rd.forward(request, response);
				}
			else
			{
				request.setAttribute("Book_flight", od1); // check
				RequestDispatcher rd = request.getRequestDispatcher("SeatFull.jsp");
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
