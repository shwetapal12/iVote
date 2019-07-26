package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.VotersAdharAfterVotingDao;
import com.dao.VotersAdharAfterVotingDaoImpl;
import com.model.VotersAdharAfterVoting;


public class DisableUserAfterVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisableUserAfterVote() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		PrintWriter out= response.getWriter();
		out.print("hello");
//		int id = request.getParameter("abc");
		String session_adharCard=(String) session.getAttribute("adharcard");
		
		 VotersAdharAfterVotingDao vdao= new VotersAdharAfterVotingDaoImpl();
         VotersAdharAfterVoting voterAdhar=null;
        
       voterAdhar= vdao.showAll(1);
       String adharCard = voterAdhar.getAdharcard();
       if(session_adharCard.equals(adharCard))
       {
    	   out.println("<h4>you have voted already </>");
       }
       else {
    	   RequestDispatcher rd= request.getRequestDispatcher("SubmitVote");
    	   rd.forward(request, response);
       }
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
