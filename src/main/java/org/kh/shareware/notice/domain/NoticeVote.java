package org.kh.shareware.notice.domain;

public class NoticeVote {
	private int noticeVoteNo;
	private int noticeNo;
	private int nVoteSc1;
	private int nVoteSc2;
	private int nVoteSc3;
	private int nVoteSc4;
	private String nVoteText1;
	private String nVoteText2;
	private String nVoteText3;
	private String nVoteText4;
	private int nVoteSelect1;
	private int nVoteSelect2;
	private int nVoteSelect3;
	private int nVoteSelect4;
	private int nVoteState;
	
	public NoticeVote() {}
	
	public NoticeVote(int noticeVoteNo, int noticeNo, int nVoteSc1, int nVoteSc2, int nVoteSc3, int nVoteSc4,
			String nVoteText1, String nVoteText2, String nVoteText3, String nVoteText4, int nVoteSelect1,
			int nVoteSelect2, int nVoteSelect3, int nVoteSelect4, int nVoteState) {
		super();
		this.noticeVoteNo = noticeVoteNo;
		this.noticeNo = noticeNo;
		this.nVoteSc1 = nVoteSc1;
		this.nVoteSc2 = nVoteSc2;
		this.nVoteSc3 = nVoteSc3;
		this.nVoteSc4 = nVoteSc4;
		this.nVoteText1 = nVoteText1;
		this.nVoteText2 = nVoteText2;
		this.nVoteText3 = nVoteText3;
		this.nVoteText4 = nVoteText4;
		this.nVoteSelect1 = nVoteSelect1;
		this.nVoteSelect2 = nVoteSelect2;
		this.nVoteSelect3 = nVoteSelect3;
		this.nVoteSelect4 = nVoteSelect4;
		this.nVoteState = nVoteState;
	}

	public int getNoticeVoteNo() {
		return noticeVoteNo;
	}

	public void setNoticeVoteNo(int noticeVoteNo) {
		this.noticeVoteNo = noticeVoteNo;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public int getnVoteSc1() {
		return nVoteSc1;
	}

	public void setnVoteSc1(int nVoteSc1) {
		this.nVoteSc1 = nVoteSc1;
	}

	public int getnVoteSc2() {
		return nVoteSc2;
	}

	public void setnVoteSc2(int nVoteSc2) {
		this.nVoteSc2 = nVoteSc2;
	}

	public int getnVoteSc3() {
		return nVoteSc3;
	}

	public void setnVoteSc3(int nVoteSc3) {
		this.nVoteSc3 = nVoteSc3;
	}

	public int getnVoteSc4() {
		return nVoteSc4;
	}

	public void setnVoteSc4(int nVoteSc4) {
		this.nVoteSc4 = nVoteSc4;
	}

	public String getnVoteText1() {
		return nVoteText1;
	}

	public void setnVoteText1(String nVoteText1) {
		this.nVoteText1 = nVoteText1;
	}

	public String getnVoteText2() {
		return nVoteText2;
	}

	public void setnVoteText2(String nVoteText2) {
		this.nVoteText2 = nVoteText2;
	}

	public String getnVoteText3() {
		return nVoteText3;
	}

	public void setnVoteText3(String nVoteText3) {
		this.nVoteText3 = nVoteText3;
	}

	public String getnVoteText4() {
		return nVoteText4;
	}

	public void setnVoteText4(String nVoteText4) {
		this.nVoteText4 = nVoteText4;
	}

	public int getnVoteSelect1() {
		return nVoteSelect1;
	}

	public void setnVoteSelect1(int nVoteSelect1) {
		this.nVoteSelect1 = nVoteSelect1;
	}

	public int getnVoteSelect2() {
		return nVoteSelect2;
	}

	public void setnVoteSelect2(int nVoteSelect2) {
		this.nVoteSelect2 = nVoteSelect2;
	}

	public int getnVoteSelect3() {
		return nVoteSelect3;
	}

	public void setnVoteSelect3(int nVoteSelect3) {
		this.nVoteSelect3 = nVoteSelect3;
	}

	public int getnVoteSelect4() {
		return nVoteSelect4;
	}

	public void setnVoteSelect4(int nVoteSelect4) {
		this.nVoteSelect4 = nVoteSelect4;
	}

	public int getnVoteState() {
		return nVoteState;
	}

	public void setnVoteState(int nVoteState) {
		this.nVoteState = nVoteState;
	}

	@Override
	public String toString() {
		return "NoticeVote [noticeVoteNo=" + noticeVoteNo + ", noticeNo=" + noticeNo + ", nVoteSc1=" + nVoteSc1
				+ ", nVoteSc2=" + nVoteSc2 + ", nVoteSc3=" + nVoteSc3 + ", nVoteSc4=" + nVoteSc4 + ", nVoteText1="
				+ nVoteText1 + ", nVoteText2=" + nVoteText2 + ", nVoteText3=" + nVoteText3 + ", nVoteText4="
				+ nVoteText4 + ", nVoteSelect1=" + nVoteSelect1 + ", nVoteSelect2=" + nVoteSelect2 + ", nVoteSelect3="
				+ nVoteSelect3 + ", nVoteSelect4=" + nVoteSelect4 + ", nVoteState=" + nVoteState + "]";
	}
	
	
	
}
