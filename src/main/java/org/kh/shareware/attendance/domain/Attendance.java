package org.kh.shareware.attendance.domain;

public class Attendance {
	private String attDate;
	private String attStrTime;
	private String attFinTime;
	private String attTotalTime;
	private String attStatus;
	private String lateNum;
	private String earlyNum;
	private String attNum;
	
	public Attendance() {}

	public Attendance(String attDate, String attStrTime, String attFinTime, String attTotalTime, String attStatus,
			String lateNum, String earlyNum, String attNum) {
		super();
		this.attDate = attDate;
		this.attStrTime = attStrTime;
		this.attFinTime = attFinTime;
		this.attTotalTime = attTotalTime;
		this.attStatus = attStatus;
		this.lateNum = lateNum;
		this.earlyNum = earlyNum;
		this.attNum = attNum;
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

	public String getLateNum() {
		return lateNum;
	}

	public void setLateNum(String lateNum) {
		this.lateNum = lateNum;
	}

	public String getEarlyNum() {
		return earlyNum;
	}

	public void setEarlyNum(String earlyNum) {
		this.earlyNum = earlyNum;
	}

	public String getAttNum() {
		return attNum;
	}

	public void setAttNum(String attNum) {
		this.attNum = attNum;
	}

	@Override
	public String toString() {
		return "Attendance [attDate=" + attDate + ", attStrTime=" + attStrTime + ", attFinTime=" + attFinTime
				+ ", attTotalTime=" + attTotalTime + ", attStatus=" + attStatus + ", lateNum=" + lateNum + ", earlyNum="
				+ earlyNum + ", attNum=" + attNum + "]";
	}


}
