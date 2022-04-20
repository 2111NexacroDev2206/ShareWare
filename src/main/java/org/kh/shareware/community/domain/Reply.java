package org.kh.shareware.community.domain;

import java.sql.Date;

public class Reply {
private int replyNo;
private int comNo;
private String memberNum;
private Date replyDate;
private String replyContent;

public Reply() {}

public Reply(int replyNo, int comNo, String memberNum, Date replyDate, String replyContent) {
	super();
	this.replyNo = replyNo;
	this.comNo = comNo;
	this.memberNum = memberNum;
	this.replyDate = replyDate;
	this.replyContent = replyContent;
}

public int getReplyNo() {
	return replyNo;
}

public void setReplyNo(int replyNo) {
	this.replyNo = replyNo;
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

public Date getReplyDate() {
	return replyDate;
}

public void setReplyDate(Date replyDate) {
	this.replyDate = replyDate;
}

public String getReplyContent() {
	return replyContent;
}

public void setReplyContent(String replyContent) {
	this.replyContent = replyContent;
}

@Override
public String toString() {
	return "Reply [replyNo=" + replyNo + ", comNo=" + comNo + ", memberNum=" + memberNum + ", replyDate=" + replyDate
			+ ", replyContent=" + replyContent + "]";
}


}
