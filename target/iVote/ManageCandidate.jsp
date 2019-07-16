<%@page import="javax.persistence.criteria.*"%>
<%@page import="com.util.HibernateGet"%>
<%@page import="org.hibernate.*"%>
<%@page import="java.util.List"%>
<%@page import="com.model.ManageCandidate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ManageCandidateImpl"%>
<%@page import="com.dao.ManageCandidateDao"%>
<%@include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 		<script src="jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
      
</head>
  <body style="background-color:orange">

        
<%
		 	String name= request.getParameter("CandidateName");
			String City= request.getParameter("City");
			String Pincode= request.getParameter("Pincode");
			ManageCandidate p= new ManageCandidate();
			p.setCandidateName(name);
			p.setCity(City);
			p.setPincode(Pincode);
			 out.println(name +" "+City+" "+Pincode);
			ManageCandidateDao pDao= new ManageCandidateImpl();
	 	pDao.insert(p);
	 	
%>
<div style="text-decoration:none ; font-size:25px; text-align: center;">
------------------<br>
<a href="AddCandidate.jsp">add a candidate</a>
<br>
------------------</centre>
</div>
<br>
 <div class="container" >      
        <center> <label><h3>Avalaible Position</h3></label></center>
 <table class="table table-stripped"><tr><th>Candidate Name</th><th>Candidate City</th>
 <th>Pincode</th>
	<th>Action</th></tr>

<%
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
		for (ManageCandidate manage_Candidate : manageCandidate)
		{
		   
			 out.println("<tr><td>"+manage_Candidate.getCandidateName()+
						"</td><td>"+manage_Candidate.getCity()+"</td><td>"+manage_Candidate.getPincode()+
						"</td><td> <a href='deleteCandidate/?id='"+manage_Candidate.candidateId+" name='button' class='btn btn-danger' >Delete Candidate</a></td></tr>");
			 
		}
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally{
			 s.close();
		 }
		
 %>
    </table>
</div>
</body>
</html>