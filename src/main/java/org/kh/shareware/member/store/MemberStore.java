package org.kh.shareware.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
	public int selectListCount(SqlSession sqlSession, Search search);
	public List<Member> selectAllSearch(SqlSession sqlSession, PageInfo pi, Search search);
	
	//조직도
	public List<Division> selectOrganization(SqlSession sqlSession);
	//조직도 사원정보
	public List<Member> selectOrgInfo(SqlSession sqlSession);

	
	// 사원 조회 모달
	public List<Member> selectAllMember(SqlSession sqlSession, String memberNum);
	public List<Member> selectMemberSearch(SqlSession sqlSession, Search search);
	public List<Member> selectAllChatMember(SqlSession sqlSession, int chatRoomNo);
	public List<Member> selectAllChatMemberSearch(SqlSession sqlSession, Search search);
	
	// 넥사크로 - 관리자
	public List<Member> selectAllMemberNexa(SqlSession sqlSession, Search search); // 사원 조회
	public int insertMember(SqlSession sqlSession, Member newMember); // 사원 등록
	public Member selectOneMember(SqlSession sqlSession, String memberNum); // 사원 상세 조회
	public int deleteMember(SqlSession sqlSession, String memberNum); // 사원 삭제
	public int updateMember(SqlSession sqlSession, Member newMember); // 사원 정보 수정
	// 조직도
	public List<Division> selectAllDivision(SqlSession sqlSession); // 부서 조회
	public List<Division> selectOneDivision(SqlSession sqlSession, String divCode); // 부서 사원 조회
	
	// 알림
	public List<Member> selectAllAlarmMember(SqlSession sqlSession); // 전체 사원 조회
	
	// 비밀번호 변경
	public int updatePassword(SqlSession sqlSession, Member member);

}