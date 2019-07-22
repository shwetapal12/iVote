package com.application;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.model.ManageCandidate;
import com.util.HibernateGet;

public class Application {
	
	
	public static void main(String[] args) {
		Session session =null;// sessionFactory.openSession();
		Transaction tx=null;
		try{
			session=HibernateGet.getSession();
			tx = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<ManageCandidate> query = builder.createQuery(ManageCandidate.class);
	         Root<ManageCandidate> root = query.from(ManageCandidate.class);
	         query.select(root);
	        Query<ManageCandidate> q=session.createQuery(query);
	         List<ManageCandidate> manageCandidate=q.getResultList();
	         for (ManageCandidate manage_Candidate : manageCandidate) {
	            System.out.println(manage_Candidate);
	         }
	       //=======================================================
	         //TO PRINT COUNT
	         
	         
	       String SQL_QUERY = "SELECT COUNT(*) FROM ManageCandidate group by candidateName";
	        // String SQL_QUERY ="select NumberOfVotes from ResultCount order by count desc";
	         Query query1 = session.createQuery(SQL_QUERY);
	           
	         for(Iterator it=query1.iterate();it.hasNext();)
	         {
	          long row = (Long) it.next();
	          System.out.print("Count: " + row);
	         }
	        // ============================================================================
	         
	         
	       //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	         //TO UPDATE THE COUTN IN THE DATABASE
//	      Scanner sc= new Scanner(System.in);
//	    
//      System.out.println("enter id");
//	      int id= sc.nextInt();   
//	      ManageCandidate mngcandidate = session.load(ManageCandidate.class, id);
//	     int count= mngcandidate.getNumbercount();
//	      mngcandidate.setCandidateId(id);  // 104 must be in the DB
//	      mngcandidate.setNumbercount(count+1);
//	      session.update(mngcandidate);
	         
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++////////////
		tx.commit();
		}
		catch (Exception e) {
			System.out.println(e);
		}		
		finally{			
				session.close();		
		}
	}
	
}
