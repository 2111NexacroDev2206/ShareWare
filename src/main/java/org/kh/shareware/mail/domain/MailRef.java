package org.kh.shareware.mail.domain;

public class MailRef {
	private int mailNo;
	private String mailReferee;
	private int refNo;
	private String refStatus;
	private String refImpStatus;
	private String refReadType;
	
	public MailRef() {}

	public MailRef(int mailNo, String mailReferee, int refNo, String refStatus, String refImpStatus,
			String refReadType) {
		super();
		this.mailNo = mailNo;
		this.mailReferee = mailReferee;
		this.refNo = refNo;
		this.refStatus = refStatus;
		this.refImpStatus = refImpStatus;
		this.refReadType = refReadType;
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

	public String getRefStatus() {
		return refStatus;
	}

	public void setRefStatus(String refStatus) {
		this.refStatus = refStatus;
	}

	public String getRefImpStatus() {
		return refImpStatus;
	}

	public void setRefImpStatus(String refImpStatus) {
		this.refImpStatus = refImpStatus;
	}

	public String getRefReadType() {
		return refReadType;
	}

	public void setRefReadType(String refReadType) {
		this.refReadType = refReadType;
	}

	@Override
	public String toString() {
		return "MailRef [mailNo=" + mailNo + ", mailReferee=" + mailReferee + ", refNo=" + refNo + ", refStatus="
				+ refStatus + ", refImpStatus=" + refImpStatus + ", refReadType=" + refReadType + "]";
	}
	
	
	
}
