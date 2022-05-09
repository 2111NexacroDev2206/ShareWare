package org.kh.shareware.chat.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
	public int modifyChatTitle(String chatTitle) { // 채팅방 제목 바꾸기
		int result = cStore.updateChatTitle(sqlSession, chatTitle);
		return result;
	}
	
}
