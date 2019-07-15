package com.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.ManageCandidate;

import com.util.HibernateGet;



public class ManageCandidateImpl implements ManageCandidateDao {

	public List<ManageCandidate> showAll() {
		Session session =null;// sessionFactory.openSession();
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
	       /*  for (Employee employee : eList) {
	            System.out.println(employee);
	         }*/
	         tx.commit();		
		}finally{
		session.close();
		//HibernateUtil.closeSessionFactory();
        }

        return eList;
	}

	}

	

