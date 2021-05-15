package com.cs425.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.CustomerDao;

/**
 * Servlet implementation class AddCreditcardController
 */
public class AddCreditcardCont extends HttpServlet  {
	/*private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  /*  public AddCreditcardController() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String CCNO = request.getParameter("newCCNo").toString();
		String CCTYPE = request.getParameter("newCCType").toString();
		String BANKNAME = request.getParameter("newBankname").toString();
		String CCEXPDate = request.getParameter("newExpirydate").toString();
		String NAMEONCARD = request.getParameter("newNameoncard").toString();
	
		Date CCEXPDATE = Date.valueOf(CCEXPDate);		
		//Date date = FormattingDate.StringToDate(dob);
/*		SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
        java.util.Date date;
		try {
			date = sdf.parse(CCEXPDate);
		
        java.sql.Date CCEXPDATE = new Date(date.getTime());     */
		
		CustomerDao od1  =  new CustomerDao();
		
		int rs = od1.addCreditcard(CCNO, CCTYPE, BANKNAME, CCEXPDATE, NAMEONCARD);
		
		if(rs > 0)
		{	
			if(CCNO == "" || CCTYPE == " " || BANKNAME == null || CCEXPDate == null || NAMEONCARD == null) {
				RequestDispatcher rd = request.getRequestDispatcher("ShowPayment.jsp");
				rd.forward(request, response);
			}
			else {
			RequestDispatcher rd = request.getRequestDispatcher("NewCCadded.jsp");
			rd.forward(request, response);
			}
		} 
		}	
	/*	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
