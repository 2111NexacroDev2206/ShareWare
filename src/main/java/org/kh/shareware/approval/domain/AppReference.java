package org.kh.shareware.approval.domain;

public class AppReference {
	private int refNo;
	private int docNo;
	private String memNum;
	
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

	@Override
	public String toString() {
		return "AppReference [refNo=" + refNo + ", docNo=" + docNo + ", memNum=" + memNum + "]";
	}
	
}
