package org.kh.shareware.member.domain;

import java.sql.Date;

public class Member {
	private String memberNum;
	private String memberName;
	private String division;
	private String rank;
	private String address;
	private String phone;
	private String mail;
	private String hireDate;
	private String retireDate;
	private String birth;
	private String account;
	private String bank;
	private String password;
	private String gender;
	private String photo;
	private String breakTotal;
	private String mStatus;
	
	public Member() {}

	public Member(String memberNum, String memberName, String division, String rank, String address, String phone,
			String mail, String hireDate, String retireDate, String birth, String account, String bank, String password,
			String gender, String photo, String breakTotal, String mStatus) {
		super();
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.division = division;
		this.rank = rank;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.hireDate = hireDate;
		this.retireDate = retireDate;
		this.birth = birth;
		this.account = account;
		this.bank = bank;
		this.password = password;
		this.gender = gender;
		this.photo = photo;
		this.breakTotal = breakTotal;
		this.mStatus = mStatus;
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

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBreakTotal() {
		return breakTotal;
	}

	public void setBreakTotal(String breakTotal) {
		this.breakTotal = breakTotal;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", memberName=" + memberName + ", division=" + division + ", rank="
				+ rank + ", address=" + address + ", phone=" + phone + ", mail=" + mail + ", hireDate=" + hireDate
				+ ", retireDate=" + retireDate + ", birth=" + birth + ", account=" + account + ", bank=" + bank
				+ ", password=" + password + ", gender=" + gender + ", photo=" + photo + ", breakTotal=" + breakTotal
				+ ", mStatus=" + mStatus + "]";
	}
	
}
