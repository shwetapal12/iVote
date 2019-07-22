package com.model;

public class ResultCount {

	private int id;
	private int CandidateId;
	private int NumberOfVotes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCandidateId() {
		return CandidateId;
	}
	public void setCandidateId(int candidateId) {
		CandidateId = candidateId;
	}
	public int getNumberOfVotes() {
		return NumberOfVotes;
	}
	public void setNumberOfVotes(int numberOfVotes) {
		NumberOfVotes = numberOfVotes;
	}
	public ResultCount(int id, int candidateId, int numberOfVotes) {
		super();
		this.id = id;
		CandidateId = candidateId;
		NumberOfVotes = numberOfVotes;
	}
	
	public ResultCount() {
		super();
		
	}
	
	

	
	
}
