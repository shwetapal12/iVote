package com.application;

import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.*;
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
