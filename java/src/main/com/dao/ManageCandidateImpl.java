package com.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;

import com.model.ManageCandidate;

import com.util.HibernateGet;
public class ManageCandidateImpl implements ManageCandidateDao {
	
	public List<ManageCandidate> showAll() {
		Session session =null;
		Transaction tx=null;
		List<ManageCandidate> eList=null;
		try{
			session=HibernateGet.getSession();
			tx = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<ManageCandidate> query = builder.createQuery(ManageCandidate.class);
	         Root<ManageCandidate> root = query.from(ManageCandidate.class);
	         query.select(root);
	         Query<ManageCandidate> q=session.createQuery(query);
	         eList=q.getResultList();	      
	         tx.commit();		
		}finally{
		session.close();
		
        }

        return eList;
	}

	public int insert(ManageCandidate p) {
		Session session =null;
		Transaction tx=null;
	int id= 0;
	
		try{
			session=HibernateGet.getSession();
			tx = session.beginTransaction();

	      id= (Integer) session.save(p);
	      tx.commit();		
		}finally{
		session.close();
		
        }
		
		return id;
	}

	public int delete(int id) {
		Session session =null;
		Transaction tx=null;
		try{
			session=HibernateGet.getSession();
			tx = session.beginTransaction();
            ManageCandidate m= session.load(ManageCandidate.class, id);
            session.delete(m);	    
	         tx.commit();		
		}catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
		session.close();
		
        }		
		return id;		
	}
	@Override
	public void updateCount(int id) {

		Session session =null;
		Transaction tx=null;
		try{ 
			
			ManageCandidate mngcandidate = session.load(ManageCandidate.class, id);
			int count= mngcandidate.getNumbercount();
			mngcandidate.setCandidateId(id);  // id must be in the DB
			mngcandidate.setNumbercount(count+1);
			session.update(mngcandidate);
	         tx.commit();		
		}finally{
		//session.close();
		//HibernateGet.closeSessionFactory();
        }		
	}
}

	

