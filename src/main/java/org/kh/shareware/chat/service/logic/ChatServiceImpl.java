package org.kh.shareware.chat.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.domain.ChatContent;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;
import org.kh.shareware.chat.service.ChatService;
import org.kh.shareware.chat.store.ChatStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatStore cStore;
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerChatRoom(ChatRoom chatRoom) { // 채팅방 생성
		int result = cStore.insertChatRoom(sqlSession, chatRoom);
		return result;
	}

	@Override
	public int registerChatMember(String memberNum) { // 채팅방 사용자 등록
		int result = cStore.insertChatMember(sqlSession, memberNum);
		return result;
	}

	@Override
	public List<ChatMember> printAllMember() { // 채팅방 사용자 목록 조회
		List<ChatMember> mList = cStore.selectListMember(sqlSession);
		return mList;
	}

	@Override
	public int registerChatContent(ChatContent chatContent) { // 채팅 등록
		int result = cStore.insertChatContent(sqlSession, chatContent);
		return result;
	}

	@Override
	public List<ChatRoom> printAllChatRoom(String memberNum) { // 채팅방 목록 조회
		List<ChatRoom> rList = cStore.selectAllChatRoom(sqlSession, memberNum);
		return rList;
	}

	@Override
	public ChatContent printChatContent(int chatRoomNo) { // 마지막 대화 내용과 날짜 가져오기
		ChatContent chatContent = cStore.selectChatContent(sqlSession, chatRoomNo);
		return chatContent;
	}
	
}
