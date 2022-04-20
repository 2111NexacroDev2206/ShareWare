package org.kh.shareware.mail.domain;

public class MailBmk {
	private int bmkNo;
	private int mailNo;
	private String bmkSubject;
	private String bmkName;
	private String bmkAddr;
	private String memNum;
	public MailBmk(int bmkNo, int mailNo, String bmkSubject, String bmkName, String bmkAddr, String memNum) {
		super();
		this.bmkNo = bmkNo;
		this.mailNo = mailNo;
		this.bmkSubject = bmkSubject;
		this.bmkName = bmkName;
		this.bmkAddr = bmkAddr;
		this.memNum = memNum;
	}
	public int getBmkNo() {
		return bmkNo;
	}
	public void setBmkNo(int bmkNo) {
		this.bmkNo = bmkNo;
	}
	public int getMailNo() {
		return mailNo;
	}
	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}
	public String getBmkSubject() {
		return bmkSubject;
	}
	public void setBmkSubject(String bmkSubject) {
		this.bmkSubject = bmkSubject;
	}
	public String getBmkName() {
		return bmkName;
	}
	public void setBmkName(String bmkName) {
		this.bmkName = bmkName;
	}
	public String getBmkAddr() {
		return bmkAddr;
	}
	public void setBmkAddr(String bmkAddr) {
		this.bmkAddr = bmkAddr;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	@Override
	public String toString() {
		return "MailBmk [bmkNo=" + bmkNo + ", mailNo=" + mailNo + ", bmkSubject=" + bmkSubject + ", bmkName=" + bmkName
				+ ", bmkAddr=" + bmkAddr + ", memNum=" + memNum + "]";
	}
	
	
}
