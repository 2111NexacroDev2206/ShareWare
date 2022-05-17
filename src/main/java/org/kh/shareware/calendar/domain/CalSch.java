package org.kh.shareware.calendar.domain;

import java.sql.Date;

public class CalSch {
	private int schNo;
	private String memNum;
	private String calNo;
	private String schName;
	private Date schStartDate;
	private String schStartTime;
	private Date schEndDate;
	private String schEndTime;
	private String schContent;
	private String alStatus;
	private String schColor;
	
	
	
	public CalSch() {}



	public CalSch(int schNo, String memNum, String calNo, String schName, Date schStartDate, String schStartTime,
			Date schEndDate, String schEndTime, String schContent, String alStatus, String schColor) {
		super();
		this.schNo = schNo;
		this.memNum = memNum;
		this.calNo = calNo;
		this.schName = schName;
		this.schStartDate = schStartDate;
		this.schStartTime = schStartTime;
		this.schEndDate = schEndDate;
		this.schEndTime = schEndTime;
		this.schContent = schContent;
		this.alStatus = alStatus;
		this.schColor = schColor;
	}



	public int getSchNo() {
		return schNo;
	}



	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}



	public String getMemNum() {
		return memNum;
	}



	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}



	public String getCalNo() {
		return calNo;
	}



	public void setCalNo(String calNo) {
		this.calNo = calNo;
	}



	public String getSchName() {
		return schName;
	}



	public void setSchName(String schName) {
		this.schName = schName;
	}



	public Date getSchStartDate() {
		return schStartDate;
	}



	public void setSchStartDate(Date schStartDate) {
		this.schStartDate = schStartDate;
	}



	public String getSchStartTime() {
		return schStartTime;
	}



	public void setSchStartTime(String schStartTime) {
		this.schStartTime = schStartTime;
	}



	public Date getSchEndDate() {
		return schEndDate;
	}



	public void setSchEndDate(Date schEndDate) {
		this.schEndDate = schEndDate;
	}



	public String getSchEndTime() {
		return schEndTime;
	}



	public void setSchEndTime(String schEndTime) {
		this.schEndTime = schEndTime;
	}



	public String getSchContent() {
		return schContent;
	}



	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}



	public String getAlStatus() {
		return alStatus;
	}



	public void setAlStatus(String alStatus) {
		this.alStatus = alStatus;
	}



	public String getSchColor() {
		return schColor;
	}



	public void setSchColor(String schColor) {
		this.schColor = schColor;
	}



	@Override
	public String toString() {
		return "CalSch [schNo=" + schNo + ", memNum=" + memNum + ", calNo=" + calNo + ", schName=" + schName
				+ ", schStartDate=" + schStartDate + ", schStartTime=" + schStartTime + ", schEndDate=" + schEndDate
				+ ", schEndTime=" + schEndTime + ", schContent=" + schContent + ", alStatus=" + alStatus + ", schColor="
				+ schColor + "]";
	}
	
	
	
}
