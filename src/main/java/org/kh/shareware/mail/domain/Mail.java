package org.kh.shareware.mail.domain;

import java.sql.Date;

public class Mail {
	private int mailNo;
	private String mailType;
	private String mailSubject;
	private String mailContent;
	private int mailCount;
	private String MailSender;
	private String mailFromAddr;
	private int rStatus;
	private int iStatus;
	private int readType;
	private int fStatus;
	private Date mailFromDate;
	private Date mailToDate;
	private Date aDate;
	private String rejReason;
	private Date resDate;
	private char resHour;
	private char resMin;
	private String memNum;
	
	
	public Mail() {}


	public Mail(int mailNo, String mailType, String mailSubject, String mailContent, int mailCount, String mailSender,
			String mailFromAddr, int rStatus, int iStatus, int readType, int fStatus, Date mailFromDate,
			Date mailToDate, Date aDate, String rejReason, Date resDate, char resHour, char resMin, String memNum) {
		super();
		this.mailNo = mailNo;
		this.mailType = mailType;
		this.mailSubject = mailSubject;
		this.mailContent = mailContent;
		this.mailCount = mailCount;
		MailSender = mailSender;
		this.mailFromAddr = mailFromAddr;
		this.rStatus = rStatus;
		this.iStatus = iStatus;
		this.readType = readType;
		this.fStatus = fStatus;
		this.mailFromDate = mailFromDate;
		this.mailToDate = mailToDate;
		this.aDate = aDate;
		this.rejReason = rejReason;
		this.resDate = resDate;
		this.resHour = resHour;
		this.resMin = resMin;
		this.memNum = memNum;
	}


	public int getMailNo() {
		return mailNo;
	}


	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}


	public String getMailType() {
		return mailType;
	}


	public void setMailType(String mailType) {
		this.mailType = mailType;
	}


	public String getMailSubject() {
		return mailSubject;
	}


	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}


	public String getMailContent() {
		return mailContent;
	}


	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}


	public int getMailCount() {
		return mailCount;
	}


	public void setMailCount(int mailCount) {
		this.mailCount = mailCount;
	}


	public String getMailSender() {
		return MailSender;
	}


	public void setMailSender(String mailSender) {
		MailSender = mailSender;
	}


	public String getMailFromAddr() {
		return mailFromAddr;
	}


	public void setMailFromAddr(String mailFromAddr) {
		this.mailFromAddr = mailFromAddr;
	}


	public int getrStatus() {
		return rStatus;
	}


	public void setrStatus(int rStatus) {
		this.rStatus = rStatus;
	}


	public int getiStatus() {
		return iStatus;
	}


	public void setiStatus(int iStatus) {
		this.iStatus = iStatus;
	}


	public int getReadType() {
		return readType;
	}


	public void setReadType(int readType) {
		this.readType = readType;
	}


	public int getfStatus() {
		return fStatus;
	}


	public void setfStatus(int fStatus) {
		this.fStatus = fStatus;
	}


	public Date getMailFromDate() {
		return mailFromDate;
	}


	public void setMailFromDate(Date mailFromDate) {
		this.mailFromDate = mailFromDate;
	}


	public Date getMailToDate() {
		return mailToDate;
	}


	public void setMailToDate(Date mailToDate) {
		this.mailToDate = mailToDate;
	}


	public Date getaDate() {
		return aDate;
	}


	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}


	public String getRejReason() {
		return rejReason;
	}


	public void setRejReason(String rejReason) {
		this.rejReason = rejReason;
	}


	public Date getResDate() {
		return resDate;
	}


	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}


	public char getResHour() {
		return resHour;
	}


	public void setResHour(char resHour) {
		this.resHour = resHour;
	}


	public char getResMin() {
		return resMin;
	}


	public void setResMin(char resMin) {
		this.resMin = resMin;
	}


	public String getMemNum() {
		return memNum;
	}


	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}


	@Override
	public String toString() {
		return "Mail [mailNo=" + mailNo + ", mailType=" + mailType + ", mailSubject=" + mailSubject + ", mailContent="
				+ mailContent + ", mailCount=" + mailCount + ", MailSender=" + MailSender + ", mailFromAddr="
				+ mailFromAddr + ", rStatus=" + rStatus + ", iStatus=" + iStatus + ", readType=" + readType
				+ ", fStatus=" + fStatus + ", mailFromDate=" + mailFromDate + ", mailToDate=" + mailToDate + ", aDate="
				+ aDate + ", rejReason=" + rejReason + ", resDate=" + resDate + ", resHour=" + resHour + ", resMin="
				+ resMin + ", memNum=" + memNum + "]";
	}


	
	
}
