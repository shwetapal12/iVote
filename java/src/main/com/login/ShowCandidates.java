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

import com.model.ManageCandidate;
import com.util.HibernateGet;

/**
 * Servlet implementation class ShowCandidates
 */
public class ShowCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session s =null;
		Transaction tx=null; 		
		 try{
			 s=HibernateGet.getSession();
		 tx = s.beginTransaction();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<ManageCandidate> query = builder.createQuery(ManageCandidate.class);
		Root<ManageCandidate> root = query.from(ManageCandidate.class);
		query.select(root);
		Query<ManageCandidate> q=s.createQuery(query);
		List<ManageCandidate> manageCandidate=q.getResultList();
		PrintWriter out= response.getWriter();
		out.write("<table class=\"table table-stripped\"><tr><th>Candidate Name</th><th>Candidate City</th>\r\n" + 
				" <th>Pincode</th>\r\n" + 
				"	<th>Action</th></tr>");
		for (ManageCandidate manage_Candidate : manageCandidate)
		{
		   
			 out.write ("<tr><td>"+manage_Candidate.getCandidateName()+
						"</td><td>"+manage_Candidate.getCity()+"</td><td>"+manage_Candidate.getPincode()+
						"</td><td> <a href='deleteCandidates?id="+manage_Candidate.candidateId+"'"
								+ " class='btn btn-danger'>Delete Me</a></td></tr>");
			 
		}
		out.write("</table>");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally{
			 s.close();
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
