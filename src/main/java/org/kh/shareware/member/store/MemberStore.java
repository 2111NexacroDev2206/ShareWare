package org.kh.shareware.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Division;
import org.kh.shareware.member.domain.Member;

public interface MemberStore {
	
	//로그인
	public Member selectLoginMember(SqlSession session, Member member);
	//마이페이지
	public Member selectOneById(SqlSession session, String memberNum);

	//주소록
	public List<Member> selectAll(SqlSession sqlSession, PageInfo pi);
	public int selectListCount(SqlSession sqlSession);
	//주소록 검색
	public List<Member> selectAllSearch(SqlSession sqlSession, PageInfo pi);
	public int selectListCountSearch(SqlSession sqlSession);
	
	//조직도
	public List<Division> selectOrganization(SqlSession sqlSession);
	
	// 사원 조회 모달
	public List<Member> selectAllMember(SqlSession sqlSession, String memberNum);
	public List<Member> selectMemberSearch(SqlSession sqlSession, Search search);
	public List<Member> selectAllChatMember(SqlSession sqlSession, int chatRoomNo);
	public List<Member> selectAllChatMemberSearch(SqlSession sqlSession, Search search);

}

