package org.kh.shareware.chat.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;
import org.kh.shareware.chat.store.ChatStore;
import org.springframework.stereotype.Repository;

@Repository
public class ChatStoreLogic implements ChatStore {

	@Override
	public int insertChatRoom(SqlSession sqlSession, ChatRoom chatRoom) { // 채팅방 생성
		int result = sqlSession.insert("ChatMapper.insertChatRoom", chatRoom);
		return result;
	}

	@Override
	public int insertChatMember(SqlSession sqlSession, String memberNum) { // 채팅방 사용자 등록
		int result = sqlSession.insert("ChatMapper.insertChatMember", memberNum);
		return result;
	}

	@Override
	public List<ChatMember> selectListMember(SqlSession sqlSession) { // 채팅방 사용자 목록 조회
		List<ChatMember> mList = sqlSession.selectList("ChatMapper.selectListMember");
		return mList;
	}

	@Override
	public int updateChatTitle(SqlSession sqlSession, String chatTitle) { // 채팅방 제목 바꾸기
		int result = sqlSession.update("ChatMapper.updateChatTitle", chatTitle);
		return result;
	}

}
