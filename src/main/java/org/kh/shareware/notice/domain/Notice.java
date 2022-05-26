package org.kh.shareware.notice.domain;


import org.kh.shareware.member.domain.Member;

public class Notice {
	private int noticeNo;
	private String memberNum;
	private String noticeDate;
	private String noticeTitle;
	private String noticeContent;
	private int noticeView;
	private String noticeImgName;
	private String noticeImgRemane;
	private String noticeImgPath;
	private String noticeDelete;
	private int noticeVoteno;
	
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Notice() {}

	public Notice(int noticeNo, String memberNum, String noticeDate, String noticeTitle, String noticeContent,
			int noticeView, String noticeImgName, String noticeImgRemane, String noticeImgPath, String noticeDelete,
			int noticeVoteno) {
		super();
		this.noticeNo = noticeNo;
		this.memberNum = memberNum;
		this.noticeDate = noticeDate;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeView = noticeView;
		this.noticeImgName = noticeImgName;
		this.noticeImgRemane = noticeImgRemane;
		this.noticeImgPath = noticeImgPath;
		this.noticeDelete = noticeDelete;
		this.noticeVoteno = noticeVoteno;
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

	public String getNoticeImgName() {
		return noticeImgName;
	}

	public void setNoticeImgName(String noticeImgName) {
		this.noticeImgName = noticeImgName;
	}

	public String getNoticeImgRemane() {
		return noticeImgRemane;
	}

	public void setNoticeImgRemane(String noticeImgRemane) {
		this.noticeImgRemane = noticeImgRemane;
	}

	public String getNoticeImgPath() {
		return noticeImgPath;
	}

	public void setNoticeImgPath(String noticeImgPath) {
		this.noticeImgPath = noticeImgPath;
	}

	public String getNoticeDelete() {
		return noticeDelete;
	}

	public void setNoticeDelete(String noticeDelete) {
		this.noticeDelete = noticeDelete;
	}

	public int getNoticeVoteno() {
		return noticeVoteno;
	}

	public void setNoticeVoteno(int noticeVoteno) {
		this.noticeVoteno = noticeVoteno;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memberNum=" + memberNum + ", noticeDate=" + noticeDate
				+ ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeView=" + noticeView
				+ ", noticeImgName=" + noticeImgName + ", noticeImgRemane=" + noticeImgRemane + ", noticeImgPath="
				+ noticeImgPath + ", noticeDelete=" + noticeDelete + ", noticeVoteno=" + noticeVoteno + "]";
	}
	
	

}
