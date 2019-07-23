package com.login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.ManageCandidateDao;
import com.dao.ManageCandidateImpl;
import com.model.ManageCandidate;
import com.util.HibernateGet;
public class ShowCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowCandidates() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManageCandidateDao mdao= new ManageCandidateImpl();
		 List<ManageCandidate> manageCandidate=mdao.showAll();			
		PrintWriter out= response.getWriter();
		out.write("<table class=\"table table-stripped table-primary\"><tr><th>Candidate Name</th><th>Candidate City</th>\r\n" + 
				" <th>Pincode</th>\r\n" + 
				"	<th>Action</th></tr>");
		for (ManageCandidate manage_Candidate : manageCandidate)
		{
		   
			 out.write ("<tr><td>"+manage_Candidate.getCandidateName()+
						"</td><td>"+manage_Candidate.getCity()+"</td><td>"+manage_Candidate.getPincode()+
						"</td><td> <a href='deleteCandidates?id="+manage_Candidate.getCandidateId()+"'"
								+ " class='btn btn-danger'>Delete Me</a></td></tr>");
			 
		}
		out.write("</table>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
