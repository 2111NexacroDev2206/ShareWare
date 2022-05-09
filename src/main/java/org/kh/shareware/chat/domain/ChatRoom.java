package org.kh.shareware.chat.domain;

public class ChatRoom {
	private int chatRoomNo;
	private String chatTitle;
	private int chatType;
	
	public ChatRoom() {}

	public int getChatRoomNo() {
		return chatRoomNo;
	}

	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}

	public String getChatTitle() {
		return chatTitle;
	}

	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}

	public int getChatType() {
		return chatType;
	}

	public void setChatType(int chatType) {
		this.chatType = chatType;
	}

	@Override
	public String toString() {
		return "ChatRoom [chatRoomNo=" + chatRoomNo + ", chatTitle=" + chatTitle + ", chatType=" + chatType + "]";
	}
	
}
