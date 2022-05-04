package org.kh.shareware.member.domain;

public class Division {
	private String divCode;
	private String divName;
	private String divLevel;
	private String parentDivCode;
	
	public Division() {}

	public Division(String divCode, String divName, String divLevel, String parentDivCode) {
		super();
		this.divCode = divCode;
		this.divName = divName;
		this.divLevel = divLevel;
		this.parentDivCode = parentDivCode;
	}


	public String getDivCode() {
		return divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public String getDivLevel() {
		return divLevel;
	}

	public void setDivLevel(String divLevel) {
		this.divLevel = divLevel;
	}

	public String getParentDivCode() {
		return parentDivCode;
	}

	public void setParentDivCode(String parentDivCode) {
		this.parentDivCode = parentDivCode;
	}

	@Override
	public String toString() {
		return "Division [divCode=" + divCode + ", divName=" + divName + ", divLevel=" + divLevel + ", parentDivCode="
				+ parentDivCode + "]";
	}
	
	

}
