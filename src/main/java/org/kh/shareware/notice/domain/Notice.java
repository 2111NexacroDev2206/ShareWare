package org.kh.shareware.notice.domain;


import org.kh.shareware.member.domain.Member;

public class Notice {
	private int noticeNo;
	private String memberNum;
	private String noticeDate;
	private String noticeTitle;
	private String noticeContent;
	private int noticeView;
	
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Notice() {}

	public Notice(int noticeNo, String memberNum, String noticeDate, String noticeTitle, String noticeContent,
			int noticeView) {
		super();
		this.noticeNo = noticeNo;
		this.memberNum = memberNum;
		this.noticeDate = noticeDate;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeView = noticeView;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeView() {
		return noticeView;
	}

	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memberNum=" + memberNum + ", noticeDate=" + noticeDate
				+ ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeView=" + noticeView
				+ "]";
	}
	
	

}
