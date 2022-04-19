package org.kh.shareware.approval.domain;

public class AppReference {
	private int refNo;
	private String docNo;
	private String memNum;
	
	public AppReference() {}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	@Override
	public String toString() {
		return "AppReference [refNo=" + refNo + ", docNo=" + docNo + ", memNum=" + memNum + "]";
	}
	
}
