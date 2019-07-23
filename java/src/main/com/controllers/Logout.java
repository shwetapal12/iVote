package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logout() {
        super();
     
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession(false);
		
		 session.removeAttribute("name");
		    session.invalidate();
		    response.sendRedirect("Adminlogin.jsp");		   
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	
}
