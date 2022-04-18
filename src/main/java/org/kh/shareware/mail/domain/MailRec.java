package org.kh.shareware.mail.domain;

public class MailRec {
	private int mailNo;
	private String mailReceiver;
	private int recNo;
	private String mailToAddr;
	public MailRec(int mailNo, String mailReceiver, int recNo, String mailToAddr) {
		super();
		this.mailNo = mailNo;
		this.mailReceiver = mailReceiver;
		this.recNo = recNo;
		this.mailToAddr = mailToAddr;
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
	public String getMailToAddr() {
		return mailToAddr;
	}
	public void setMailToAddr(String mailToAddr) {
		this.mailToAddr = mailToAddr;
	}
	@Override
	public String toString() {
		return "MailRec [mailNo=" + mailNo + ", mailReceiver=" + mailReceiver + ", recNo=" + recNo + ", mailToAddr="
				+ mailToAddr + "]";
	}
	
	
}
