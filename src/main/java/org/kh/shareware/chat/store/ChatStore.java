package org.kh.shareware.chat.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;

public interface ChatStore {

	public int insertChatRoom(SqlSession sqlSession, ChatRoom chatRoom); // 채팅방 생성
	public int insertChatMember(SqlSession sqlSession, String memberNum); // 채팅방 사용자 등록
	public List<ChatMember> selectListMember(SqlSession sqlSession); // 채팅방 사용자 목록 조회
	public int updateChatTitle(SqlSession sqlSession, String chatTitle); // 채팅방 제목 바꾸기

}
