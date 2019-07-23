package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManageCandidateDao;
import com.dao.ManageCandidateImpl;

public class deleteCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public deleteCandidates() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt( request.getParameter("id"));
		ManageCandidateDao pDao= new ManageCandidateImpl();
		pDao.delete(id);
		response.sendRedirect("Ajax.jsp");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
