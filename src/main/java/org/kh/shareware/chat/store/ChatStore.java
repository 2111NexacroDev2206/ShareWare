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
	public List<ChatContent> selectAllChatRoom(SqlSession sqlSession, int chatRoomNo); // 채팅 목록
	public int selectOneChatMemberCount(SqlSession sqlSession, int chatRoomNo); // 채팅 인원수 조회
	public int selectOneChatRoomType(SqlSession sqlSession, int chatRoomNo); // 채팅방 종류 조회
	public int updateStatusChatMember(SqlSession sqlSession, ChatMember chatMember); // 채팅방 나가기
	public ChatMember selectOneChatMember(SqlSession sqlSession, ChatMember chatMember); // 채팅방 사용자 조회
	public int selectOneContentDate(SqlSession sqlSession, ChatContent chatContent); // 날짜 공지 찾기
	public int insertInviteChatMember(SqlSession sqlSession, ChatMember member); // 사용자 추가 초대
	public int updateStatusChatRoom(SqlSession sqlSession, ChatRoom chatRoom); // 채팅방 종류 변경
	public int deleteChatRoom(SqlSession sqlSession, int chatRoomNo); // 채팅방 삭제

}
