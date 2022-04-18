package org.kh.shareware.calendar.domain;

import java.sql.Date;

public class CalSch {
	private int schNo;
	private String memNum;
	private String calNo;
	private String schName;
	private String calName;
	private Date schStartDate;
	private char schStartHour;
	private char schStartMin;
	private Date schEndDate;
	private char schEndHour;
	private char schEndMin;
	private String schContent;
	private Date schWriDate;
	private Date schModDate;
	
	
	
	public CalSch() {}
	public CalSch(int schNo, String memNum, String calNo, String schName, String calName, Date schStartDate,
			char schStartHour, char schStartMin, Date schEndDate, char schEndHour, char schEndMin, String schContent,
			Date schWriDate, Date schModDate) {
		super();
		this.schNo = schNo;
		this.memNum = memNum;
		this.calNo = calNo;
		this.schName = schName;
		this.calName = calName;
		this.schStartDate = schStartDate;
		this.schStartHour = schStartHour;
		this.schStartMin = schStartMin;
		this.schEndDate = schEndDate;
		this.schEndHour = schEndHour;
		this.schEndMin = schEndMin;
		this.schContent = schContent;
		this.schWriDate = schWriDate;
		this.schModDate = schModDate;
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
	public String getCalName() {
		return calName;
	}
	public void setCalName(String calName) {
		this.calName = calName;
	}
	public Date getSchStartDate() {
		return schStartDate;
	}
	public void setSchStartDate(Date schStartDate) {
		this.schStartDate = schStartDate;
	}
	public char getSchStartHour() {
		return schStartHour;
	}
	public void setSchStartHour(char schStartHour) {
		this.schStartHour = schStartHour;
	}
	public char getSchStartMin() {
		return schStartMin;
	}
	public void setSchStartMin(char schStartMin) {
		this.schStartMin = schStartMin;
	}
	public Date getSchEndDate() {
		return schEndDate;
	}
	public void setSchEndDate(Date schEndDate) {
		this.schEndDate = schEndDate;
	}
	public char getSchEndHour() {
		return schEndHour;
	}
	public void setSchEndHour(char schEndHour) {
		this.schEndHour = schEndHour;
	}
	public char getSchEndMin() {
		return schEndMin;
	}
	public void setSchEndMin(char schEndMin) {
		this.schEndMin = schEndMin;
	}
	public String getSchContent() {
		return schContent;
	}
	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}
	public Date getSchWriDate() {
		return schWriDate;
	}
	public void setSchWriDate(Date schWriDate) {
		this.schWriDate = schWriDate;
	}
	public Date getSchModDate() {
		return schModDate;
	}
	public void setSchModDate(Date schModDate) {
		this.schModDate = schModDate;
	}
	@Override
	public String toString() {
		return "CalSch [schNo=" + schNo + ", memNum=" + memNum + ", calNo=" + calNo + ", schName=" + schName
				+ ", calName=" + calName + ", schStartDate=" + schStartDate + ", schStartHour=" + schStartHour
				+ ", schStartMin=" + schStartMin + ", schEndDate=" + schEndDate + ", schEndHour=" + schEndHour
				+ ", schEndMin=" + schEndMin + ", schContent=" + schContent + ", schWriDate=" + schWriDate
				+ ", schModDate=" + schModDate + "]";
	}
	
	
	
}
