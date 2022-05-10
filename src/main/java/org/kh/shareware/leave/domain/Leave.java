package org.kh.shareware.leave.domain;

public class Leave {
	private float leaveTotal;
	private float leaveUse;
	private float leaveRemain;
	
	public Leave() {}

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

	@Override
	public String toString() {
		return "Leave [leaveTotal=" + leaveTotal + ", leaveUse=" + leaveUse + ", leaveRemain=" + leaveRemain + "]";
	}

}
