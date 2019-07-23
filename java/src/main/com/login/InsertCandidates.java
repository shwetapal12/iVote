package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManageCandidateDao;
import com.dao.ManageCandidateImpl;
import com.model.ManageCandidate;

public class InsertCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name= request.getParameter("CandidateName");
		String City= request.getParameter("City");
		String Pincode= request.getParameter("Pincode");
		ManageCandidate p= new ManageCandidate();
		p.setCandidateName(name);
		p.setCity(City);
		p.setPincode(Pincode);		
		ManageCandidateDao pDao= new ManageCandidateImpl();
		pDao.insert(p);
		response.sendRedirect("Ajax.jsp");		
	}
}
