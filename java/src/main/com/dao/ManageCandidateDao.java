package com.dao;
import java.util.List;

import com.model.ManageCandidate;

public interface ManageCandidateDao {
	public int insert(ManageCandidate p);
	public int delete(int id);
	
	public List<ManageCandidate> showAll(); 
	public void updateCount(int id);

	




		
	

}
