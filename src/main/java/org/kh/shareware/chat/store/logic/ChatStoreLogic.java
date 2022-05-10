package org.kh.shareware.chat.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.domain.ChatContent;
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
	public int insertChatContent(SqlSession sqlSession, ChatContent chatContent) { // 채팅 등록
		int result = sqlSession.insert("ChatMapper.insertChatContent", chatContent);
		return result;
	}

	@Override
	public List<ChatRoom> selectAllChatRoom(SqlSession sqlSession, String memberNum) { // 채팅방 목록 조회
		List<ChatRoom> rList = sqlSession.selectList("ChatMapper.selectListChatRoom", memberNum);
		return rList;
	}

	@Override
	public ChatContent selectChatContent(SqlSession sqlSession, int chatRoomNo) { // 마지막 대화 내용과 날짜 가져오기
		ChatContent chatContent = sqlSession.selectOne("ChatMapper.selectOneChatContent", chatRoomNo);
		return chatContent;
	}

	@Override
	public List<ChatContent> selectAllChatRoom(SqlSession sqlSession, int chatRoomNo) { // 채팅 목록
		List<ChatContent> cList = sqlSession.selectList("ChatMapper.selectListChat", chatRoomNo);
		return cList;
	}

}
