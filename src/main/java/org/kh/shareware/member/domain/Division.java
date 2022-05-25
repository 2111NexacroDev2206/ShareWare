package org.kh.shareware.member.domain;

public class Division {
	private String divCode;
	private String divName;
	private String divLevel;
	private String parentDivCode;
	private String memberName;
	private String rank;
	private String birth;
	private String mail;
	private String phone;
	private String address;
	private String hireDate;
	
	public Division() {}

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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Division [divCode=" + divCode + ", divName=" + divName + ", divLevel=" + divLevel + ", parentDivCode="
				+ parentDivCode + ", memberName=" + memberName + ", rank=" + rank + ", birth=" + birth + ", mail="
				+ mail + ", phone=" + phone + ", address=" + address + ", hireDate=" + hireDate + "]";
	}
	
}
