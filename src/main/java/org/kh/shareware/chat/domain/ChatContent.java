package org.kh.shareware.chat.domain;

public class ChatContent {
	private int chatContentNo;
	private int chatRoomNo;
	private String chatContent;
	private String memNum;
	private String chatDate;
	
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

	public String getChatDate() {
		return chatDate;
	}

	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	@Override
	public String toString() {
		return "ChatContent [chatContentNo=" + chatContentNo + ", chatRoomNo=" + chatRoomNo + ", chatContent="
				+ chatContent + ", memNum=" + memNum + ", chatDate=" + chatDate + "]";
	}
	
}
