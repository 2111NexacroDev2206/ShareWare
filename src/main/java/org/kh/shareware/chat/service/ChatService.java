package org.kh.shareware.chat.service;

import java.util.List;

import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;

public interface ChatService {

	public int registerChatRoom(ChatRoom chatRoom); // 채팅방 생성
	public int registerChatMember(String memberNum); // 채팅방 사용자 등록
	public List<ChatMember> printAllMember(); // 채팅방 사용자 목록 조회
	public int modifyChatTitle(String chatTitle); // 채팅방 제목 바꾸기

}
