package org.kh.shareware.approval.domain;

public class Approval {
	private int appNo;
	private String docNo;
	private String memNum;
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

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
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
		return "Approval [appNo=" + appNo + ", docNo=" + docNo + ", memNum=" + memNum + ", appLevel=" + appLevel
				+ ", appDate=" + appDate + ", appStatus=" + appStatus + ", rejReason=" + rejReason + "]";
	}
	
}
