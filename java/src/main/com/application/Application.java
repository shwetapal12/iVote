package com.application;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.ManageCandidateDao;
import com.dao.ManageCandidateImpl;
import com.dao.VotersAdharAfterVotingDao;
import com.dao.VotersAdharAfterVotingDaoImpl;
import com.model.ManageCandidate;
import com.model.VotersAdharAfterVoting;



public class Application {
	
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Session session =null;
		Transaction tx=null;

//		ManageCandidateDao mdao= new ManageCandidateImpl();
//		 List<ManageCandidate> manageCandidate=mdao.showAll();
//	         for (ManageCandidate manage_Candidate : manageCandidate) {
//	            System.out.println(manage_Candidate);
//	         }
	         
	         
	         //System.out.println(mdao.delete(34));
	        // mdao.updateCount(22);
	         
	       //=======================================================
	         //TO PRINT COUNT
	         
//	         String SQL_QUERY = "SELECT candidateId, candidateName, numbercount FROM ManageCandidate order by numbercount desc";
//	         Query query1 = session.createQuery(SQL_QUERY);
//	         
//	         List<Object[]> collection1 = query1.getResultList(); 
//	     	
//	     	
//	     	System.out.println("Retrieving values in multiple columns ");
//	     	 for(Object[] user: collection1)
//	     	 {
//	     		 System.out.println("Id : " +(Integer)user[0]);
//	     		 System.out.println("Id : " +user[1]);
//	     		 System.out.println("First Name : " +(Integer) user[2]);
//	     		 System.out.println();
//	     	 }     
//	         
//	        // ============================================================================
	         
	         
	       //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	         //TO UPDATE THE COUTN IN THE DATABASE
//	      Scanner sc= new Scanner(System.in);
//	    
//      System.out.println("enter id");
//	      int id= sc.nextInt();   
//	      ManageCandidate mngcandidate = session.load(ManageCandidate.class, id);
//	     int count= mngcandidate.getNumbercount();
//	      mngcandidate.setCandidateId(id);  // id must be in the DB
//	      mngcandidate.setNumbercount(count+1);
//	      session.update(mngcandidate);
	         
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++////////////

	         //&&&&&&&&&&&&&&&&&//VOTERS ADHARA//&&&&&&&&&&&&&&&&&&
	         
	         VotersAdharAfterVotingDao vdao= new VotersAdharAfterVotingDaoImpl();
	         VotersAdharAfterVoting voterAdhar=null;
	         voterAdhar=  new VotersAdharAfterVoting(5,"888845450007");
	       int res=  vdao.insertAdharCard(voterAdhar);
	         if(res>=1)
	         {
	        	 System.out.println("data inserted");
	         }
	         else {
	        	 System.out.println("data not inserted");
	         }
	         
	         
	       voterAdhar= vdao.showAll(4);
	       System.out.println(voterAdhar.getAdharcard());
	}
	
}
