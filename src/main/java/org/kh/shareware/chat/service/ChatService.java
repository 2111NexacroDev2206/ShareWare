package org.kh.shareware.chat.service;

import java.util.List;

import org.kh.shareware.chat.domain.ChatContent;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;

public interface ChatService {

	public int registerChatRoom(ChatRoom chatRoom); // 채팅방 생성
	public int registerChatMember(String memberNum); // 채팅방 사용자 등록
	public List<ChatMember> printAllMember(); // 채팅방 사용자 목록 조회
	public int registerChatContent(ChatContent chatContent); // 채팅 등록
	public List<ChatRoom> printAllChatRoom(String memberNum); // 채팅방 목록 조회
	public ChatContent printChatContent(int chatRoomNo); // 마지막 대화 내용과 날짜 가져오기

}
