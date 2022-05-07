package org.kh.shareware.alarm.domain;

import java.sql.Date;

public class Alarm {
	private int alarmNo;
	private String memNum;
	private String kind;
	private String alarmContent;
	private Date alarmDate;
	private String alarmStatus;
	
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

	public Date getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}

	@Override
	public String toString() {
		return "Alarm [alarmNo=" + alarmNo + ", memNum=" + memNum + ", kind=" + kind + ", alarmContent=" + alarmContent
				+ ", alarmDate=" + alarmDate + ", alarmStatus=" + alarmStatus + "]";
	}
	
}
