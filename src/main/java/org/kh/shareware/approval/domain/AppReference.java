package org.kh.shareware.approval.domain;

public class AppReference {
	private int refNo;
	private int docNo;
	private String memNum;
	private String division;
	private String rank;
	private String refStatus;
	
	public AppReference() {}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public int getDocNo() {
		return docNo;
	}

	public void setDocNo(int docNo) {
		this.docNo = docNo;
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

	public String getRefStatus() {
		return refStatus;
	}

	public void setRefStatus(String refStatus) {
		this.refStatus = refStatus;
	}

	@Override
	public String toString() {
		return "AppReference [refNo=" + refNo + ", docNo=" + docNo + ", memNum=" + memNum + ", division=" + division
				+ ", rank=" + rank + ", refStatus=" + refStatus + "]";
	}

}
