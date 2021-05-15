package com.cs425.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.Book_flightDao;
import com.cs425.web.dao.CustomerDao;
import com.cs425.web.dao.FlightDao;
import com.cs425.web.model.Book_flight;
import com.cs425.web.model.Flight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
/**
 * Servlet implementation class SearchFlightCont
 */
public class SearchFlightCont extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  /*  public SearchFlightCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String ARRDEST = request.getParameter("arr_dest").toString();
		String DEPDEST = request.getParameter("dep_dest").toString();
		String Flightdate = request.getParameter("flightdate").toString();
		String ORDERBY = request.getParameter("orderby").toString();
		String RETURNFLIGHT = request.getParameter("returnflight").toString();
		
		Date FLIGHTDATE = Date.valueOf(Flightdate);
		
	/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm");
        java.util.Date date;
		try {
			date = sdf.parse(Flightdate);
		
        java.sql.Date FLIGHTDATE = new Date(date.getTime()); */
		
	//	if(RETURNFLIGHT.equalsIgnoreCase("no")) 
		{
		FlightDao od1 = new FlightDao();
		
		Flight ob1 = od1.getSearchflight(ARRDEST, DEPDEST, FLIGHTDATE, ORDERBY, RETURNFLIGHT);
		
		request.setAttribute("Flight", ob1);  // fetch this attribute in the JSP file
		
		RequestDispatcher rd = request.getRequestDispatcher("SearchFlightResultPage.jsp");
		rd.forward(request, response);
	}
		
	}
/*	 catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	} */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
