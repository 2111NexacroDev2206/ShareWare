package org.kh.shareware.mail.domain;

public class MailRef {
	private int mailNo;
	private String mailReferee;
	private int refNo;
	private String mailToAddr;
	
	public MailRef() {}
	public MailRef(int mailNo, String mailReferee, int refNo, String mailToAddr) {
		super();
		this.mailNo = mailNo;
		this.mailReferee = mailReferee;
		this.refNo = refNo;
		this.mailToAddr = mailToAddr;
	}
	public int getMailNo() {
		return mailNo;
	}
	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}
	public String getMailReferee() {
		return mailReferee;
	}
	public void setMailReferee(String mailReferee) {
		this.mailReferee = mailReferee;
	}
	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	public String getMailToAddr() {
		return mailToAddr;
	}
	public void setMailToAddr(String mailToAddr) {
		this.mailToAddr = mailToAddr;
	}
	@Override
	public String toString() {
		return "MailRef [mailNo=" + mailNo + ", mailReferee=" + mailReferee + ", refNo=" + refNo + ", mailToAddr="
				+ mailToAddr + "]";
	}
	
	
}
