package org.kh.shareware.alarm.domain;

public class Alarm {
	private int alarmNo;
	private String memNum;
	private String kind;
	private String alarmContent;
	private String alarmDate;
	private String alarmStatus;
	private String alarmUrl;
	
	public Alarm() {}

	public int getAlarmNo() {
		return alarmNo;
	}

	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getAlarmContent() {
		return alarmContent;
	}

	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}

	public String getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(String alarmDate) {
		this.alarmDate = alarmDate;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}

	public String getAlarmUrl() {
		return alarmUrl;
	}

	public void setAlarmUrl(String alarmUrl) {
		this.alarmUrl = alarmUrl;
	}

	@Override
	public String toString() {
		return "Alarm [alarmNo=" + alarmNo + ", memNum=" + memNum + ", kind=" + kind + ", alarmContent=" + alarmContent
				+ ", alarmDate=" + alarmDate + ", alarmStatus=" + alarmStatus + ", alarmUrl=" + alarmUrl + "]";
	}

}
