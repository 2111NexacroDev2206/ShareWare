package org.kh.shareware.mail.domain;

public class MailBmk {
	private int bmkNo;
	private String bmkSubject;
	private String bmkAddr;
	private String bmkName;
	private String memNum;
	private String division;
	private String rank;
	private String bmkMemNum;
	
	
	public MailBmk() {}


	public MailBmk(int bmkNo, String bmkSubject, String bmkAddr, String bmkName, String memNum, String division,
			String rank, String bmkMemNum) {
		super();
		this.bmkNo = bmkNo;
		this.bmkSubject = bmkSubject;
		this.bmkAddr = bmkAddr;
		this.bmkName = bmkName;
		this.memNum = memNum;
		this.division = division;
		this.rank = rank;
		this.bmkMemNum = bmkMemNum;
	}


	public int getBmkNo() {
		return bmkNo;
	}


	public void setBmkNo(int bmkNo) {
		this.bmkNo = bmkNo;
	}


	public String getBmkSubject() {
		return bmkSubject;
	}


	public void setBmkSubject(String bmkSubject) {
		this.bmkSubject = bmkSubject;
	}


	public String getBmkAddr() {
		return bmkAddr;
	}


	public void setBmkAddr(String bmkAddr) {
		this.bmkAddr = bmkAddr;
	}


	public String getBmkName() {
		return bmkName;
	}


	public void setBmkName(String bmkName) {
		this.bmkName = bmkName;
	}


	public String getMemNum() {
		return memNum;
	}


	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getBmkMemNum() {
		return bmkMemNum;
	}


	public void setBmkMemNum(String bmkMemNum) {
		this.bmkMemNum = bmkMemNum;
	}


	@Override
	public String toString() {
		return "MailBmk [bmkNo=" + bmkNo + ", bmkSubject=" + bmkSubject + ", bmkAddr=" + bmkAddr + ", bmkName="
				+ bmkName + ", memNum=" + memNum + ", division=" + division + ", rank=" + rank + ", bmkMemNum="
				+ bmkMemNum + "]";
	}

	

	
	
	
}
