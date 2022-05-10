package org.kh.shareware.chat.domain;

public class ChatRoom {
	private int chatRoomNo;
	private String chatRoomTitle;
	private int chatRoomType;
	private String chatContent;
	private String chatDate;
	
	public ChatRoom() {}

	public int getChatRoomNo() {
		return chatRoomNo;
	}

	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}

	public String getChatRoomTitle() {
		return chatRoomTitle;
	}

	public void setChatRoomTitle(String chatRoomTitle) {
		this.chatRoomTitle = chatRoomTitle;
	}

	public int getChatRoomType() {
		return chatRoomType;
	}

	public void setChatRoomType(int chatRoomType) {
		this.chatRoomType = chatRoomType;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getChatDate() {
		return chatDate;
	}

	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	@Override
	public String toString() {
		return "ChatRoom [chatRoomNo=" + chatRoomNo + ", chatRoomTitle=" + chatRoomTitle + ", chatRoomType="
				+ chatRoomType + ", chatContent=" + chatContent + ", chatDate=" + chatDate + "]";
	}
	
}
