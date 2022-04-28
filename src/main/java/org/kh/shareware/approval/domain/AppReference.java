package org.kh.shareware.approval.domain;

public class AppReference {
	private int refNo;
	private int docNo;
	private String memNum;
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

	public String getRefStatus() {
		return refStatus;
	}

	public void setRefStatus(String refStatus) {
		this.refStatus = refStatus;
	}

	@Override
	public String toString() {
		return "AppReference [refNo=" + refNo + ", docNo=" + docNo + ", memNum=" + memNum + ", refStatus=" + refStatus
				+ "]";
	}

}
