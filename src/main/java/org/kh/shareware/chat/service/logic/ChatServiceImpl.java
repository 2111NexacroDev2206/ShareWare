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
	public List<ChatMember> printAllMember(ChatRoom chatRoom) { // 채팅방 사용자 목록 조회
		List<ChatMember> mList = cStore.selectListMember(sqlSession, chatRoom);
		return mList;
	}

	@Override
	public int registerChatContent(ChatContent chatContent) { // 채팅 등록
		int result = cStore.insertChatContent(sqlSession, chatContent);
		return result;
	}
	
	@Override
	public int printChatRoomNo() { // 채팅방 번호 불러오기
		int chatRoomNo = cStore.selectOneChatRoomNo(sqlSession);
		return chatRoomNo;
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

	@Override
	public List<ChatContent> printAllChat(int chatRoomNo) { // 채팅 목록
		List<ChatContent> cList = cStore.selectAllChatRoom(sqlSession, chatRoomNo);
		return cList;
	}
	
	@Override
	public int printChatMemberCount(int chatRoomNo) { // 채팅 인원수 조회
		int count = cStore.selectOneChatMemberCount(sqlSession, chatRoomNo);
		return count;
	}
	
	@Override
	public ChatRoom printChatRoom(int chatRoomNo) { // 채팅방 정보 조회
		ChatRoom chatRoom = cStore.selectOneChatRoom(sqlSession, chatRoomNo);
		return chatRoom;
	}
	
	@Override
	public int modifyStatusChatMember(ChatMember chatMember) { // 채팅방 나가기
		int result = cStore.updateStatusChatMember(sqlSession, chatMember);
		return result;
	}

	@Override
	public ChatMember printChatMember(ChatMember chatMember) { // 채팅방 사용자 조회
		ChatMember member = cStore.selectOneChatMember(sqlSession, chatMember);
		return member;
	}

	@Override
	public int fineContentDate(ChatContent chatContent) { // 날짜 공지 찾기
		int fineCount = cStore.selectOneContentDate(sqlSession, chatContent);
		return fineCount;
	}

	@Override
	public int inviteChatMember(ChatMember member) { // 사용자 추가 초대
		int result = cStore.insertInviteChatMember(sqlSession, member);
		return result;
	}

	@Override
	public int modifyStatusChatRoom(ChatRoom chatRoom) { // 채팅방 종류 변경
		int result = cStore.updateStatusChatRoom(sqlSession, chatRoom);
		return result;
	}

	@Override
	public int removeChatRoom(int chatRoomNo) { // 채팅방 삭제
		int result = cStore.deleteChatRoom(sqlSession, chatRoomNo);
		return result;
	}
	
}
