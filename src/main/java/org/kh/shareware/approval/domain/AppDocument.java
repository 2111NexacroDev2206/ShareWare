package org.kh.shareware.approval.domain;

import java.sql.Date;

public class AppDocument {
	private int docNo;
	private String memNum;
	private int formNo;
	private String docTitle;
	private String docContent;
	private String docStatus;
	private String docDate;
	private String leaveType;
	private String leaveStart;
	private String leaveEnd;
	private String leaveTime;
	private float leaveDay;
	
	public AppDocument() {}

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

	public int getFormNo() {
		return formNo;
	}

	public void setFormNo(int formNo) {
		this.formNo = formNo;
	}

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveStart() {
		return leaveStart;
	}

	public void setLeaveStart(String leaveStart) {
		this.leaveStart = leaveStart;
	}

	public String getLeaveEnd() {
		return leaveEnd;
	}

	public void setLeaveEnd(String leaveEnd) {
		this.leaveEnd = leaveEnd;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public float getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(float leaveDay) {
		this.leaveDay = leaveDay;
	}

	@Override
	public String toString() {
		return "AppDocument [docNo=" + docNo + ", memNum=" + memNum + ", formNo=" + formNo + ", docTitle=" + docTitle
				+ ", docContent=" + docContent + ", docStatus=" + docStatus + ", docDate=" + docDate + ", leaveType="
				+ leaveType + ", leaveStart=" + leaveStart + ", leaveEnd=" + leaveEnd + ", leaveTime=" + leaveTime
				+ ", leaveDay=" + leaveDay + "]";
	}

}
