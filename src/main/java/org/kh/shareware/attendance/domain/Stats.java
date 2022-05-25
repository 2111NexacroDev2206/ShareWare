package org.kh.shareware.attendance.domain;

public class Stats {
	private String attStatus;
	private String attCount;
	private String MemNum;	
	
	private int lateNum;  //지각
	private int attNum;   //출근
	private int absNum;   //결근
	
	public Stats() {}
/*
	public Stats(String attStatus, String attCount, String memNum) {
		super();
		this.attStatus = attStatus;
		this.attCount = attCount;
		this.MemNum = memNum;
	}
*/
	public String getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(String AttStatus) {
		this.attStatus = AttStatus;
	}

	public String getAttCount() {
		return attCount;
	}

	public void setAttCount(String AttCount) {
		this.attCount = AttCount;
	}

	public String getMemNum() {
		return MemNum;
	}

	public void setMemNum(String memNum) {
		this.MemNum = memNum;
	}
	
	public int getLateNum() {
		return lateNum;
	}
	public void setLateNum(int lateNum) {
		this.lateNum = lateNum;
	}
	
	public int getAttNum() {
		return attNum;
	}
	public void setAttNum(int attNum) {
		this.attNum = attNum;
	}
	
	public int getAbsNum() {
		return absNum;
	}
	public void setAbsNum(int absNum) {
		this.absNum = absNum;
	}
		
	@Override
	public String toString() {
		return "Stats [lateNum=" + lateNum + ", attNum=" + attNum + ", absNum=" + absNum + "]";
	}

}
