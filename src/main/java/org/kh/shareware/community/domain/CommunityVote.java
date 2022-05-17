package org.kh.shareware.community.domain;

public class CommunityVote {
private int comVoteNo;
private int comNo;
private int cVoteSc1;
private int cVoteSc2;
private int cVoteSc3;
private int cVoteSc4;
private String cVoteText1;
private String cVoteText2;
private String cVoteText3;
private String cVoteText4;
private int cVoteSelect1;
private int cVoteSelect2;
private int cVoteSelect3;
private int cVoteSelect4;
private int cVoteState;

private CommunityVoteSelect cVoteSelect;


public CommunityVoteSelect getcVoteSelect() {
	return cVoteSelect;
}

public void setcVoteSelect(CommunityVoteSelect cVoteSelect) {
	this.cVoteSelect = cVoteSelect;
}

public CommunityVote() {}

public CommunityVote(int comVoteNo, int comNo, int cVoteSc1, int cVoteSc2, int cVoteSc3, int cVoteSc4,
		String cVoteText1, String cVoteText2, String cVoteText3, String cVoteText4, int cVoteSelect1, int cVoteSelect2,
		int cVoteSelect3, int cVoteSelect4, int cVoteState) {
	super();
	this.comVoteNo = comVoteNo;
	this.comNo = comNo;
	this.cVoteSc1 = cVoteSc1;
	this.cVoteSc2 = cVoteSc2;
	this.cVoteSc3 = cVoteSc3;
	this.cVoteSc4 = cVoteSc4;
	this.cVoteText1 = cVoteText1;
	this.cVoteText2 = cVoteText2;
	this.cVoteText3 = cVoteText3;
	this.cVoteText4 = cVoteText4;
	this.cVoteSelect1 = cVoteSelect1;
	this.cVoteSelect2 = cVoteSelect2;
	this.cVoteSelect3 = cVoteSelect3;
	this.cVoteSelect4 = cVoteSelect4;
	this.cVoteState = cVoteState;
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

public int getcVoteSc1() {
	return cVoteSc1;
}

public void setcVoteSc1(int cVoteSc1) {
	this.cVoteSc1 = cVoteSc1;
}

public int getcVoteSc2() {
	return cVoteSc2;
}

public void setcVoteSc2(int cVoteSc2) {
	this.cVoteSc2 = cVoteSc2;
}

public int getcVoteSc3() {
	return cVoteSc3;
}

public void setcVoteSc3(int cVoteSc3) {
	this.cVoteSc3 = cVoteSc3;
}

public int getcVoteSc4() {
	return cVoteSc4;
}

public void setcVoteSc4(int cVoteSc4) {
	this.cVoteSc4 = cVoteSc4;
}

public String getcVoteText1() {
	return cVoteText1;
}

public void setcVoteText1(String cVoteText1) {
	this.cVoteText1 = cVoteText1;
}

public String getcVoteText2() {
	return cVoteText2;
}

public void setcVoteText2(String cVoteText2) {
	this.cVoteText2 = cVoteText2;
}

public String getcVoteText3() {
	return cVoteText3;
}

public void setcVoteText3(String cVoteText3) {
	this.cVoteText3 = cVoteText3;
}

public String getcVoteText4() {
	return cVoteText4;
}

public void setcVoteText4(String cVoteText4) {
	this.cVoteText4 = cVoteText4;
}

public int getcVoteSelect1() {
	return cVoteSelect1;
}

public void setcVoteSelect1(int cVoteSelect1) {
	this.cVoteSelect1 = cVoteSelect1;
}

public int getcVoteSelect2() {
	return cVoteSelect2;
}

public void setcVoteSelect2(int cVoteSelect2) {
	this.cVoteSelect2 = cVoteSelect2;
}

public int getcVoteSelect3() {
	return cVoteSelect3;
}

public void setcVoteSelect3(int cVoteSelect3) {
	this.cVoteSelect3 = cVoteSelect3;
}

public int getcVoteSelect4() {
	return cVoteSelect4;
}

public void setcVoteSelect4(int cVoteSelect4) {
	this.cVoteSelect4 = cVoteSelect4;
}

public int getcVoteState() {
	return cVoteState;
}

public void setcVoteState(int cVoteState) {
	this.cVoteState = cVoteState;
}

@Override
public String toString() {
	return "CommunityVote [comVoteNo=" + comVoteNo + ", comNo=" + comNo + ", cVoteSc1=" + cVoteSc1 + ", cVoteSc2="
			+ cVoteSc2 + ", cVoteSc3=" + cVoteSc3 + ", cVoteSc4=" + cVoteSc4 + ", cVoteText1=" + cVoteText1
			+ ", cVoteText2=" + cVoteText2 + ", cVoteText3=" + cVoteText3 + ", cVoteText4=" + cVoteText4
			+ ", cVoteSelect1=" + cVoteSelect1 + ", cVoteSelect2=" + cVoteSelect2 + ", cVoteSelect3=" + cVoteSelect3
			+ ", cVoteSelect4=" + cVoteSelect4 + ", cVoteState=" + cVoteState + "]";
}


}
