package org.kh.shareware.community.domain;

import java.sql.Date;

import org.kh.shareware.member.domain.Member;

public class Community {
private int comNo;
private String memberNum;
private Date comDate;
private String comTitle;
private String comContent;
private int comView;
private String comImgName;
private String comImgRename;
private String comImgPath;
private int comVoteNo;

private Member member;

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}

public Community() {}

public Community(int comNo, String memberNum, Date comDate, String comTitle, String comContent, int comView,
		String comImgName, String comImgRename, String comImgPath, int comVoteNo) {
	super();
	this.comNo = comNo;
	this.memberNum = memberNum;
	this.comDate = comDate;
	this.comTitle = comTitle;
	this.comContent = comContent;
	this.comView = comView;
	this.comImgName = comImgName;
	this.comImgRename = comImgRename;
	this.comImgPath = comImgPath;
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

public Date getComDate() {
	return comDate;
}

public void setComDate(Date comDate) {
	this.comDate = comDate;
}

public String getComTitle() {
	return comTitle;
}

public void setComTitle(String comTitle) {
	this.comTitle = comTitle;
}

public String getComContent() {
	return comContent;
}

public void setComContent(String comContent) {
	this.comContent = comContent;
}

public int getComView() {
	return comView;
}

public void setComView(int comView) {
	this.comView = comView;
}

public String getComImgName() {
	return comImgName;
}

public void setComImgName(String comImgName) {
	this.comImgName = comImgName;
}

public String getComImgRename() {
	return comImgRename;
}

public void setComImgRename(String comImgRename) {
	this.comImgRename = comImgRename;
}

public String getComImgPath() {
	return comImgPath;
}

public void setComImgPath(String comImgPath) {
	this.comImgPath = comImgPath;
}

public int getComVoteNo() {
	return comVoteNo;
}

public void setComVoteNo(int comVoteNo) {
	this.comVoteNo = comVoteNo;
}

@Override
public String toString() {
	return "Community [comNo=" + comNo + ", memberNum=" + memberNum + ", comDate=" + comDate + ", comTitle=" + comTitle
			+ ", comContent=" + comContent + ", comView=" + comView + ", comImgName=" + comImgName + ", comImgRename="
			+ comImgRename + ", comImgPath=" + comImgPath + ", comVoteNo=" + comVoteNo
			+ "]";
};


}
