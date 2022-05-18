package org.kh.shareware.calendar.domain;


public class CalSch {
	private int schNo;
	private String memNum;
	private String calNo;
	private String schName;
	private String schStartDate;
	private String schStartTime;
	private String schEndDate;
	private String schEndTime;
	private String schContent;
	private String alStatus;
	private String schColor;
	
	
	
	public CalSch() {}



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



	public String getSchStartDate() {
		return schStartDate;
	}



	public void setSchStartDate(String schStartDate) {
		this.schStartDate = schStartDate;
	}



	public String getSchStartTime() {
		return schStartTime;
	}



	public void setSchStartTime(String schStartTime) {
		this.schStartTime = schStartTime;
	}



	public String getSchEndDate() {
		return schEndDate;
	}



	public void setSchEndDate(String schEndDate) {
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
