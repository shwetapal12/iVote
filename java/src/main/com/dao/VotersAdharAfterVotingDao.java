package com.dao;

import com.model.VotersAdharAfterVoting;

public interface VotersAdharAfterVotingDao {

	public int insertAdharCard(VotersAdharAfterVoting voterAdhar);
	public VotersAdharAfterVoting showAll(int id);
}
