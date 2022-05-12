package org.kh.shareware.chat.domain;

import java.util.Date;

public class ChatContent {
	private int chatContentNo;
	private int chatRoomNo;
	private String chatContent;
	private String memNum;
	private String divName;
	private String memName;
	private String rankName;
	private Date chatDate;
	private String chatDateFormat;
	private int chatType;
	
	public ChatContent() {}

	public int getChatContentNo() {
		return chatContentNo;
	}

	public void setChatContentNo(int chatContentNo) {
		this.chatContentNo = chatContentNo;
	}

	public int getChatRoomNo() {
		return chatRoomNo;
	}

	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public Date getChatDate() {
		return chatDate;
	}

	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}

	public String getChatDateFormat() {
		return chatDateFormat;
	}

	public void setChatDateFormat(String chatDateFormat) {
		this.chatDateFormat = chatDateFormat;
	}

	public int getChatType() {
		return chatType;
	}

	public void setChatType(int chatType) {
		this.chatType = chatType;
	}

	@Override
	public String toString() {
		return "ChatContent [chatContentNo=" + chatContentNo + ", chatRoomNo=" + chatRoomNo + ", chatContent="
				+ chatContent + ", memNum=" + memNum + ", divName=" + divName + ", memName=" + memName + ", rankName="
				+ rankName + ", chatDate=" + chatDate + ", chatDateFormat=" + chatDateFormat + ", chatType=" + chatType
				+ "]";
	}
	
}
