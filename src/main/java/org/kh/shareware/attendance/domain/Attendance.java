package org.kh.shareware.attendance.domain;

public class Attendance {
	private int attNo;
	private String attDate;
	private String attStrTime;
	private String attFinTime;
	private String attTotalTime;
	private String attStatus;
	private int lateNum;
	private int earlyNum;
	private int attNum;
	
	public Attendance() {}

	public Attendance(int attNo, String attDate, String attStrTime, String attFinTime, String attTotalTime,
			String attStatus, int lateNum, int earlyNum, int attNum) {
		super();
		this.attNo = attNo;
		this.attDate = attDate;
		this.attStrTime = attStrTime;
		this.attFinTime = attFinTime;
		this.attTotalTime = attTotalTime;
		this.attStatus = attStatus;
		this.lateNum = lateNum;
		this.earlyNum = earlyNum;
		this.attNum = attNum;
	}

	public int getAttNo() {
		return attNo;
	}

	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}

	public String getAttDate() {
		return attDate;
	}

	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}

	public String getAttStrTime() {
		return attStrTime;
	}

	public void setAttStrTime(String attStrTime) {
		this.attStrTime = attStrTime;
	}

	public String getAttFinTime() {
		return attFinTime;
	}

	public void setAttFinTime(String attFinTime) {
		this.attFinTime = attFinTime;
	}

	public String getAttTotalTime() {
		return attTotalTime;
	}

	public void setAttTotalTime(String attTotalTime) {
		this.attTotalTime = attTotalTime;
	}

	public String getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(String attStatus) {
		this.attStatus = attStatus;
	}

	public int getLateNum() {
		return lateNum;
	}

	public void setLateNum(int lateNum) {
		this.lateNum = lateNum;
	}

	public int getEarlyNum() {
		return earlyNum;
	}

	public void setEarlyNum(int earlyNum) {
		this.earlyNum = earlyNum;
	}

	public int getAttNum() {
		return attNum;
	}

	public void setAttNum(int attNum) {
		this.attNum = attNum;
	}

	@Override
	public String toString() {
		return "Attendance [attNo=" + attNo + ", attDate=" + attDate + ", attStrTime=" + attStrTime + ", attFinTime="
				+ attFinTime + ", attTotalTime=" + attTotalTime + ", attStatus=" + attStatus + ", lateNum=" + lateNum
				+ ", earlyNum=" + earlyNum + ", attNum=" + attNum + "]";
	}

	
	
}