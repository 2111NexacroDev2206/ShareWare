package org.kh.shareware.leave.domain;

public class LeaveList {
	private String leaveType;
	private String leaveStart;
	private String leaveEnd;
	private int leaveDay;
	
	public LeaveList() {}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveStart() {
		return leaveStart;
	}

	public void setLeaveStart(String leaveStart) {
		this.leaveStart = leaveStart;
	}

	public String getLeaveEnd() {
		return leaveEnd;
	}

	public void setLeaveEnd(String leaveEnd) {
		this.leaveEnd = leaveEnd;
	}

	public int getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}

	@Override
	public String toString() {
		return "LeaveList [leaveType=" + leaveType + ", leaveStart=" + leaveStart + ", leaveEnd=" + leaveEnd
				+ ", leaveDay=" + leaveDay + "]";
	}
	
	
}
