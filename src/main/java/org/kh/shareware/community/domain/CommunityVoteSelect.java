package org.kh.shareware.community.domain;

public class CommunityVoteSelect {
private int comVoteNo;
private int comNo;
private String memberNum;
private int cSelectTrue;
private int cSelect;

public CommunityVoteSelect() {}

public CommunityVoteSelect(int comVoteNo, int comNo, String memberNum, int cSelectTrue, int cSelect) {
	super();
	this.comVoteNo = comVoteNo;
	this.comNo = comNo;
	this.memberNum = memberNum;
	this.cSelectTrue = cSelectTrue;
	this.cSelect = cSelect;
}

public int getComVoteNo() {
	return comVoteNo;
}

public void setComVoteNo(int comVoteNo) {
	this.comVoteNo = comVoteNo;
}

public int getComNo() {
	return comNo;
}

public void setComNo(int comNo) {
	this.comNo = comNo;
}

public String getMemberNum() {
	return memberNum;
}

public void setMemberNum(String memberNum) {
	this.memberNum = memberNum;
}

public int getcSelectTrue() {
	return cSelectTrue;
}

public void setcSelectTrue(int cSelectTrue) {
	this.cSelectTrue = cSelectTrue;
}

public int getcSelect() {
	return cSelect;
}

public void setcSelect(int cSelect) {
	this.cSelect = cSelect;
}

@Override
public String toString() {
	return "CommunityVoteSelect [comVoteNo=" + comVoteNo + ", comNo=" + comNo + ", memberNum=" + memberNum
			+ ", cSelectTrue=" + cSelectTrue + ", cSelect=" + cSelect + "]";
}
}
