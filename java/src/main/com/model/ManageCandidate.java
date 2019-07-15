package com.model;

public class ManageCandidate {

	
	public int candidateId;
	public String candidateName;
	public String city;
	public String pincode;
	
	
	public ManageCandidate(int candidateId, String candidateName, String city, String pincode) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.city = city;
		this.pincode = pincode;
	}


	public ManageCandidate() {
		super();
	}


	public int getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}


	public String getCandidateName() {
		return candidateName;
	}


	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
		
	
	
}