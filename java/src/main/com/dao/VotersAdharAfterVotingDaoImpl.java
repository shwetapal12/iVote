package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.VotersAdharAfterVoting;
import com.util.HibernateGet;

public class VotersAdharAfterVotingDaoImpl implements VotersAdharAfterVotingDao
{

	@Override
	public int insertAdharCard(VotersAdharAfterVoting voterAdhar) {
		
		Session session= null;
		Transaction tx= null;
		int result=0;
	
		
		try {
		session= HibernateGet.getSession();
		tx= session.beginTransaction();
		result = (int) session.save(voterAdhar);
		tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
		
		
		return result;
		

	}

	@Override
	public VotersAdharAfterVoting showAll(int id) {
		
		Session session= null;
		Transaction tx= null;
		VotersAdharAfterVoting voterAdhar=null;
		
		try {
		session= HibernateGet.getSession();
		tx= session.beginTransaction();
		voterAdhar =  session.load(VotersAdharAfterVoting.class, id);
		tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
		
		
		return voterAdhar;
	}

}
