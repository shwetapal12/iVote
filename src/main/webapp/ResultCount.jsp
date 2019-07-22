
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.util.HibernateGet"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

Session s=null;// sessionFactory.openSession();
Transaction tx=null;
try{
	s=HibernateGet.getSession();
	tx = s.beginTransaction();
	String SQL_QUERY = "SELECT COUNT(*) FROM ManageCandidate group by candidateName";
    Query query1 = s.createQuery(SQL_QUERY);
      
    for(Iterator it=query1.iterate();it.hasNext();)
    {
     long row = (Long) it.next();
     out.print("Count: " + row);
    }
    tx.commit();
}
catch(Exception e){
	tx.rollback();
}
%>

</body>
</html>