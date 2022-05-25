package org.kh.shareware.attendance.domain;

public class Attendance {
	private int attNo;
	private String attDate;
	private String attStrTime;
	private String attFinTime;
	private String attTotalTime;
	private String attStatus;
	private String memNum;
	private String memberName;
	private String division;
	
	public Attendance() {}

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

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "Attendance [attNo=" + attNo + ", attDate=" + attDate + ", attStrTime=" + attStrTime + ", attFinTime="
				+ attFinTime + ", attTotalTime=" + attTotalTime + ", attStatus=" + attStatus + ", memNum=" + memNum
				+ ", memberName=" + memberName + ", division=" + division + "]";
	}
	
}