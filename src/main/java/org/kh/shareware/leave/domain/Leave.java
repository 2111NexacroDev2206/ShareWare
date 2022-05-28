package org.kh.shareware.leave.domain;

public class Leave {
	private int leaveNo;
	private float leaveTotal;
	private float leaveUse;
	private float leaveRemain;
	private String memberNum;
	private String memberName;
	private String hireDate;
	
	public Leave() {}

	public int getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(int leaveNo) {
		this.leaveNo = leaveNo;
	}

	public float getLeaveTotal() {
		return leaveTotal;
	}

	public void setLeaveTotal(float leaveTotal) {
		this.leaveTotal = leaveTotal;
	}

	public float getLeaveUse() {
		return leaveUse;
	}

	public void setLeaveUse(float leaveUse) {
		this.leaveUse = leaveUse;
	}

	public float getLeaveRemain() {
		return leaveRemain;
	}

	public void setLeaveRemain(float leaveRemain) {
		this.leaveRemain = leaveRemain;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Leave [leaveNo=" + leaveNo + ", leaveTotal=" + leaveTotal + ", leaveUse=" + leaveUse + ", leaveRemain="
				+ leaveRemain + ", memberNum=" + memberNum + ", memberName=" + memberName + ", hireDate=" + hireDate
				+ "]";
	}
	
}
