package org.kh.shareware.attendance.domain;

public class Stats {
	private String attStatus;
	private String attCount;
	private String MemNum;
	
	public Stats() {}

	public Stats(String attStatus, String attCount, String memNum) {
		super();
		this.attStatus = attStatus;
		this.attCount = attCount;
		MemNum = memNum;
	}

	public String getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(String attStatus) {
		this.attStatus = attStatus;
	}

	public String getAttCount() {
		return attCount;
	}

	public void setAttCount(String attCount) {
		this.attCount = attCount;
	}

	public String getMemNum() {
		return MemNum;
	}

	public void setMemNum(String memNum) {
		MemNum = memNum;
	}

	@Override
	public String toString() {
		return "Stats [attStatus=" + attStatus + ", attCount=" + attCount + ", MemNum=" + MemNum + "]";
	}

}
