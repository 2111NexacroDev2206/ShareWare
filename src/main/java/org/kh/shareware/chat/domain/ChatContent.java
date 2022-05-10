package org.kh.shareware.chat.domain;

import java.sql.Date;

public class ChatContent {
	private int chatContentNo;
	private int chatRoomNo;
	private String chatContent;
	private String memNum;
	private Date chatDate;
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

	public Date getChatDate() {
		return chatDate;
	}

	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
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
				+ chatContent + ", memNum=" + memNum + ", chatDate=" + chatDate + ", chatType=" + chatType + "]";
	}
	
}
