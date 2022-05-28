package org.kh.shareware.mail.domain;

import java.sql.Date;
import java.util.List;

public class Mail {
	private int mailNo;
	private String mailType;
	private String mailSubject;
	private String mailContent;
	private int mailCount;
	private String MailSender;
	private String rStatus;
	private String iStatus;
	private String readType;
	private String fStatus;
	private Date mailFromDate;
	private Date mailToDate;
	private String aStatus;
	private Date aDate;
	private String rejReason;
	private Date resDate;
	private char resHour;
	private char resMin;
	private String memNum;
	private String mailStatus;
	private String mailReceiver;
	private String mailReferee;
	private int recNo;
	private String recStatus;
	private String recImpStatus;
	private String recReadType;
	private String mailFileName;
	private String mailFileRename;
	private String mailFilePath;
	private String refYn;
	private List<MailRec> recList;
	private List<MailRef> refList;
	
	public Mail() {}

	public Mail(int mailNo, String mailType, String mailSubject, String mailContent, int mailCount, String mailSender,
			String rStatus, String iStatus, String readType, String fStatus, Date mailFromDate, Date mailToDate,
			String aStatus, Date aDate, String rejReason, Date resDate, char resHour, char resMin, String memNum,
			String mailStatus, String mailReceiver, String mailReferee, int recNo, String recStatus,
			String recImpStatus, String recReadType, String mailFileName, String mailFileRename, String mailFilePath,
			String refYn, List<MailRec> recList, List<MailRef> refList) {
		super();
		this.mailNo = mailNo;
		this.mailType = mailType;
		this.mailSubject = mailSubject;
		this.mailContent = mailContent;
		this.mailCount = mailCount;
		MailSender = mailSender;
		this.rStatus = rStatus;
		this.iStatus = iStatus;
		this.readType = readType;
		this.fStatus = fStatus;
		this.mailFromDate = mailFromDate;
		this.mailToDate = mailToDate;
		this.aStatus = aStatus;
		this.aDate = aDate;
		this.rejReason = rejReason;
		this.resDate = resDate;
		this.resHour = resHour;
		this.resMin = resMin;
		this.memNum = memNum;
		this.mailStatus = mailStatus;
		this.mailReceiver = mailReceiver;
		this.mailReferee = mailReferee;
		this.recNo = recNo;
		this.recStatus = recStatus;
		this.recImpStatus = recImpStatus;
		this.recReadType = recReadType;
		this.mailFileName = mailFileName;
		this.mailFileRename = mailFileRename;
		this.mailFilePath = mailFilePath;
		this.refYn = refYn;
		this.recList = recList;
		this.refList = refList;
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

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public String getiStatus() {
		return iStatus;
	}

	public void setiStatus(String iStatus) {
		this.iStatus = iStatus;
	}

	public String getReadType() {
		return readType;
	}

	public void setReadType(String readType) {
		this.readType = readType;
	}

	public String getfStatus() {
		return fStatus;
	}

	public void setfStatus(String fStatus) {
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

	public String getaStatus() {
		return aStatus;
	}

	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
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

	public String getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}

	public String getMailReceiver() {
		return mailReceiver;
	}

	public void setMailReceiver(String mailReceiver) {
		this.mailReceiver = mailReceiver;
	}

	public String getMailReferee() {
		return mailReferee;
	}

	public void setMailReferee(String mailReferee) {
		this.mailReferee = mailReferee;
	}

	public int getRecNo() {
		return recNo;
	}

	public void setRecNo(int recNo) {
		this.recNo = recNo;
	}

	public String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}

	public String getRecImpStatus() {
		return recImpStatus;
	}

	public void setRecImpStatus(String recImpStatus) {
		this.recImpStatus = recImpStatus;
	}

	public String getRecReadType() {
		return recReadType;
	}

	public void setRecReadType(String recReadType) {
		this.recReadType = recReadType;
	}

	public String getMailFileName() {
		return mailFileName;
	}

	public void setMailFileName(String mailFileName) {
		this.mailFileName = mailFileName;
	}

	public String getMailFileRename() {
		return mailFileRename;
	}

	public void setMailFileRename(String mailFileRename) {
		this.mailFileRename = mailFileRename;
	}

	public String getMailFilePath() {
		return mailFilePath;
	}

	public void setMailFilePath(String mailFilePath) {
		this.mailFilePath = mailFilePath;
	}

	public String getRefYn() {
		return refYn;
	}

	public void setRefYn(String refYn) {
		this.refYn = refYn;
	}

	public List<MailRec> getRecList() {
		return recList;
	}

	public void setRecList(List<MailRec> recList) {
		this.recList = recList;
	}

	public List<MailRef> getRefList() {
		return refList;
	}

	public void setRefList(List<MailRef> refList) {
		this.refList = refList;
	}

	@Override
	public String toString() {
		return "Mail [mailNo=" + mailNo + ", mailType=" + mailType + ", mailSubject=" + mailSubject + ", mailContent="
				+ mailContent + ", mailCount=" + mailCount + ", MailSender=" + MailSender + ", rStatus=" + rStatus
				+ ", iStatus=" + iStatus + ", readType=" + readType + ", fStatus=" + fStatus + ", mailFromDate="
				+ mailFromDate + ", mailToDate=" + mailToDate + ", aStatus=" + aStatus + ", aDate=" + aDate
				+ ", rejReason=" + rejReason + ", resDate=" + resDate + ", resHour=" + resHour + ", resMin=" + resMin
				+ ", memNum=" + memNum + ", mailStatus=" + mailStatus + ", mailReceiver=" + mailReceiver
				+ ", mailReferee=" + mailReferee + ", recNo=" + recNo + ", recStatus=" + recStatus + ", recImpStatus="
				+ recImpStatus + ", recReadType=" + recReadType + ", mailFileName=" + mailFileName + ", mailFileRename="
				+ mailFileRename + ", mailFilePath=" + mailFilePath + ", refYn=" + refYn + ", recList=" + recList
				+ ", refList=" + refList + "]";
	}

	
	

	
	
}
