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
	public List<ChatMember> selectListMember(SqlSession sqlSession, ChatRoom chatRoom) { // 채팅방 사용자 목록 조회
		List<ChatMember> mList = sqlSession.selectList("ChatMapper.selectListMember", chatRoom);
		return mList;
	}

	@Override
	public int insertChatContent(SqlSession sqlSession, ChatContent chatContent) { // 채팅 등록
		int result = sqlSession.insert("ChatMapper.insertChatContent", chatContent);
		return result;
	}
	
	@Override
	public int selectOneChatRoomNo(SqlSession sqlSession) { // 채팅방 번호 불러오기
		int chatRoomNo = sqlSession.selectOne("ChatMapper.selectOnechatRoomNo");
		return chatRoomNo;
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
	public List<ChatContent> selectAllChat(SqlSession sqlSession, int chatRoomNo) { // 채팅 목록
		List<ChatContent> cList = sqlSession.selectList("ChatMapper.selectListChat", chatRoomNo);
		return cList;
	}
	
	@Override
	public int selectOneChatMemberCount(SqlSession sqlSession, int chatRoomNo) { // 채팅 인원수 조회
		int count = sqlSession.selectOne("ChatMapper.selectOneChatMemberCount", chatRoomNo);
		return count;
	}
	
	@Override
	public ChatRoom selectOneChatRoom(SqlSession sqlSession, int chatRoomNo) { // 채팅방 정보 조회
		ChatRoom chatRoom = sqlSession.selectOne("ChatMapper.selectOneChatRoom", chatRoomNo);
		return chatRoom;
	}

	@Override
	public int updateStatusChatMember(SqlSession sqlSession, ChatMember chatMember) { // 사용자 상태 변경
		int result = sqlSession.update("ChatMapper.updateStatusChatMember", chatMember);
		return result;
	}
	
	@Override
	public int updateChatTitle(SqlSession sqlSession, ChatRoom chatRoom) { // 채팅방 제목 변경
		int result = sqlSession.update("ChatMapper.updateChatTitle", chatRoom);
		return result;
	}

	@Override
	public ChatMember selectOneChatMember(SqlSession sqlSession, ChatMember chatMember) { // 채팅방 사용자 조회
		ChatMember member = sqlSession.selectOne("ChatMapper.selectOneChatMember", chatMember);
		return member;
	}

	@Override
	public int selectOneContentDate(SqlSession sqlSession, ChatContent chatContent) { // 날짜 공지 찾기
		int fineCount = sqlSession.selectOne("ChatMapper.selectOneContentDate", chatContent);
		return fineCount;
	}

	@Override
	public int insertInviteChatMember(SqlSession sqlSession, ChatMember member) { // 사용자 추가 초대
		int result = sqlSession.insert("ChatMapper.insertInviteChatMember", member);
		return result;
	}

	@Override
	public int updateStatusChatRoom(SqlSession sqlSession, ChatRoom chatRoom) { // 채팅방 종류 변경
		int result = sqlSession.update("ChatMapper.updateStatusChatRoom", chatRoom);
		return result;
	}

	@Override
	public int deleteChatRoom(SqlSession sqlSession, int chatRoomNo) { // 채팅방 삭제
		int result = sqlSession.delete("ChatMapper.deleteChatRoom", chatRoomNo);
		return result;
	}

}
