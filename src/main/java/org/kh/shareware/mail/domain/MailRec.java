package org.kh.shareware.mail.domain;

public class MailRec {
	private int mailNo;
	private String mailReceiver;
	private int recNo;
	private String recStatus;
	private String recImpStatus;
	private String recReadType;
	public MailRec(){}
	public MailRec(int mailNo, String mailReceiver, int recNo, String recStatus, String recImpStatus,
			String recReadType) {
		super();
		this.mailNo = mailNo;
		this.mailReceiver = mailReceiver;
		this.recNo = recNo;
		this.recStatus = recStatus;
		this.recImpStatus = recImpStatus;
		this.recReadType = recReadType;
	}
	public int getMailNo() {
		return mailNo;
	}
	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}
	public String getMailReceiver() {
		return mailReceiver;
	}
	public void setMailReceiver(String mailReceiver) {
		this.mailReceiver = mailReceiver;
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
	@Override
	public String toString() {
		return "MailRec [mailNo=" + mailNo + ", mailReceiver=" + mailReceiver + ", recNo=" + recNo + ", recStatus="
				+ recStatus + ", recImpStatus=" + recImpStatus + ", recReadType=" + recReadType + "]";
	}

	
	
	
	
}
