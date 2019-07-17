package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminLogin
 */
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session=null;
		String m_UserName= request.getParameter("UserName");
		String m_Password= request.getParameter("Password");
		
		if(m_UserName=="ivote" && m_Password=="iVote@India")
		{
			 session= request.getSession(true);
			session.setAttribute("name", "m_UserName");
			response.sendRedirect("Home.jsp");
		}
		else
		{
			out.print("<h4>invalid </h4>");
		}
		
		
		
		
	}

}
