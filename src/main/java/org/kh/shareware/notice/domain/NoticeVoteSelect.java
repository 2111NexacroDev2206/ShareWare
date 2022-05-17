package org.kh.shareware.notice.domain;

public class NoticeVoteSelect {
	private int notiveVoteNo;
	private int noticeNo;
	private String memberNum;
	private int nSelectTrue;
	private int nSelect;
	
	public NoticeVoteSelect (){}

	public NoticeVoteSelect(int notiveVoteNo, int noticeNo, String memberNum, int nSelectTrue, int nSelect) {
		super();
		this.notiveVoteNo = notiveVoteNo;
		this.noticeNo = noticeNo;
		this.memberNum = memberNum;
		this.nSelectTrue = nSelectTrue;
		this.nSelect = nSelect;
	}

	public int getNotiveVoteNo() {
		return notiveVoteNo;
	}

	public void setNotiveVoteNo(int notiveVoteNo) {
		this.notiveVoteNo = notiveVoteNo;
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

	public int getnSelectTrue() {
		return nSelectTrue;
	}

	public void setnSelectTrue(int nSelectTrue) {
		this.nSelectTrue = nSelectTrue;
	}

	public int getnSelect() {
		return nSelect;
	}

	public void setnSelect(int nSelect) {
		this.nSelect = nSelect;
	}

	@Override
	public String toString() {
		return "noticeVoteSelect [notiveVoteNo=" + notiveVoteNo + ", noticeNo=" + noticeNo + ", memberNum=" + memberNum
				+ ", nSelectTrue=" + nSelectTrue + ", nSelect=" + nSelect + "]";
	}
	
	
}
