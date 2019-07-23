package com.model;

public class ManageCandidate {
	private int candidateId;
	private String candidateName;
	private String city;
	private String pincode;
	private int numbercount;
	
	public ManageCandidate(int candidateId, String candidateName, String city, String pincode, int numbercount) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.city = city;
		this.pincode = pincode;
		this.numbercount = numbercount;
	}
	public int getNumbercount() {
		return numbercount;
	}
	public void setNumbercount(int numbercount) {
		this.numbercount = numbercount;
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
	@Override
	public String toString() {
		return "ManageCandidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
}