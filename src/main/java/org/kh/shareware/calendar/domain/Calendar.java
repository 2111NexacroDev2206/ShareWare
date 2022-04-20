package org.kh.shareware.calendar.domain;

public class Calendar {
	private String calNo;
	private int schNo;
	private String memNum;
	private String calName;
	private String memName;
	private String memDivision;
	private String memRank;
	
	public Calendar() {}
	public Calendar(String calNo, int schNo, String memNum, String calName, String memName, String memDivision,
			String memRank) {
		super();
		this.calNo = calNo;
		this.schNo = schNo;
		this.memNum = memNum;
		this.calName = calName;
		this.memName = memName;
		this.memDivision = memDivision;
		this.memRank = memRank;
	}
	public String getCalNo() {
		return calNo;
	}
	public void setCalNo(String calNo) {
		this.calNo = calNo;
	}
	public int getSchNo() {
		return schNo;
	}
	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getCalName() {
		return calName;
	}
	public void setCalName(String calName) {
		this.calName = calName;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemDivision() {
		return memDivision;
	}
	public void setMemDivision(String memDivision) {
		this.memDivision = memDivision;
	}
	public String getMemRank() {
		return memRank;
	}
	public void setMemRank(String memRank) {
		this.memRank = memRank;
	}
	@Override
	public String toString() {
		return "Calander [calNo=" + calNo + ", schNo=" + schNo + ", memNum=" + memNum + ", calName=" + calName
				+ ", memName=" + memName + ", memDivision=" + memDivision + ", memRank=" + memRank + "]";
	}
	
}
