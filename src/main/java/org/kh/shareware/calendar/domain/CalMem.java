package org.kh.shareware.calendar.domain;

public class CalMem {
	private String memNum;
	private String calNo;
	private int schNo;
	private String calName;
	private String memName;
	private String memDivision;
	private String memRank;
	
	public CalMem() {}
	public CalMem(String memNum, String calNo, int schNo, String calName, String memName, String memDivision,
			String memRank) {
		super();
		this.memNum = memNum;
		this.calNo = calNo;
		this.schNo = schNo;
		this.calName = calName;
		this.memName = memName;
		this.memDivision = memDivision;
		this.memRank = memRank;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
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
		return "CalMem [memNum=" + memNum + ", calNo=" + calNo + ", schNo=" + schNo + ", calName=" + calName
				+ ", memName=" + memName + ", memDivision=" + memDivision + ", memRank=" + memRank + "]";
	}
		
}
