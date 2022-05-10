package org.kh.shareware.chat.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.domain.ChatContent;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;

public interface ChatStore {

	public int insertChatRoom(SqlSession sqlSession, ChatRoom chatRoom); // 채팅방 생성
	public int insertChatMember(SqlSession sqlSession, String memberNum); // 채팅방 사용자 등록
	public List<ChatMember> selectListMember(SqlSession sqlSession); // 채팅방 사용자 목록 조회
	public int insertChatContent(SqlSession sqlSession, ChatContent chatContent); // 채팅 등록
	public List<ChatRoom> selectAllChatRoom(SqlSession sqlSession, String memberNum); // 채팅방 목록 조회
	public ChatContent selectChatContent(SqlSession sqlSession, int chatRoomNo); // 마지막 대화 내용과 날짜 가져오기

}
