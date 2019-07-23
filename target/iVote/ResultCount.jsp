<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.util.HibernateGet"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  session = request.getSession(false);
response.setHeader("Cache-Control","no-cache ,no-store,must-revalidate");
if (session.getAttribute("name") != null)
{
%>
<h4 class="text-success">Welcome <%out.print(session.getAttribute("name")); %></h4>
<%
Session s=null;// sessionFactory.openSession();
Transaction tx=null;
try{
	s=HibernateGet.getSession();
	tx = s.beginTransaction();
	
	String SQL_QUERY = "SELECT candidateId, candidateName, numbercount FROM ManageCandidate order by numbercount desc";
    Query query1 = s.createQuery(SQL_QUERY);    
    List<Object[]> collection1 = query1.getResultList();     
	System.out.println("Retrieving values in multiple columns ");	
	%>
	<div class="container">
	<table class="table table-stripped table-primary"><tr><th>Candidate Id</th><th>Candidate Name</th><th>Vote Count</th>
		<%for(Object[] user: collection1)
	 {%>
		 <tr><td><%=(Integer)user[0]%></td><td><%=user[1]%></td><td><%=(Integer) user[2] %></td></tr>
		<%		
	 }      	
   		 tx.commit();
	}
	catch(Exception e){
	//tx.rollback();
}
%>
</table></div>
</body>
<%@include file="Footer.jsp" %>
</html>
<% }
else
{
		response.sendRedirect("Logout");
	}
	%>