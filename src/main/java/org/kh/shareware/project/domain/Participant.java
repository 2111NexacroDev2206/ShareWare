package org.kh.shareware.project.domain;

public class Participant {
	private String memberNum;
	private int projectNo;
	private String memberName;
	private String division;
	private String rank;
	
	public Participant() {
		
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Participant [memberNum=" + memberNum + ", projectNo=" + projectNo + ", memberName=" + memberName
				+ ", division=" + division + ", rank=" + rank + "]";
	}
	
}
