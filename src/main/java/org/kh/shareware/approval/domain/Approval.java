package org.kh.shareware.approval.domain;

public class Approval {
	private int appNo;
	private int docNo;
	private String memNum;
	private String memberName;
	private String division;
	private String rank;
	private int appLevel;
	private String appDate;
	private String appStatus;
	private String rejReason;
	
	public Approval() {}

	public int getAppNo() {
		return appNo;
	}

	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}

	public int getDocNo() {
		return docNo;
	}

	public void setDocNo(int docNo) {
		this.docNo = docNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
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

	public int getAppLevel() {
		return appLevel;
	}

	public void setAppLevel(int appLevel) {
		this.appLevel = appLevel;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getRejReason() {
		return rejReason;
	}

	public void setRejReason(String rejReason) {
		this.rejReason = rejReason;
	}

	@Override
	public String toString() {
		return "Approval [appNo=" + appNo + ", docNo=" + docNo + ", memNum=" + memNum + ", memberName=" + memberName
				+ ", division=" + division + ", rank=" + rank + ", appLevel=" + appLevel + ", appDate=" + appDate
				+ ", appStatus=" + appStatus + ", rejReason=" + rejReason + "]";
	}

}
