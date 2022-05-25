package org.kh.shareware.member.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Division;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.service.MemberService;
import org.kh.shareware.member.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession sqlSession;
	
	//로그인
	@Override
	public Member loginMember(Member member) {
		Member memberOne = mStore.selectLoginMember(sqlSession, member);
		return memberOne;
	}
	
	//마이페이지
	@Override
	public Member printOneById(String memberNum) {
		Member memberOne = mStore.selectOneById(sqlSession, memberNum);
		return memberOne;
	}

	//주소록
	@Override
	public List<Member> printAll(PageInfo pi) {
		List<Member> mList = mStore.selectAll(sqlSession, pi);
		return mList;
	}
	@Override
	public int getListCount() {
		int totalCount = mStore.selectListCount(sqlSession);
		return totalCount;
	}
	//주소록 검색
	@Override
	public int getListCount(Search search) {
		int totalCount = mStore.selectListCount(sqlSession, search);
		return totalCount;
	}
	@Override
	public List<Member> printAllSearch(Search search, PageInfo pi) {
		List<Member> mList = mStore.selectAllSearch(sqlSession, pi, search);
		return mList;
	}
	
	//조직도
	@Override
	public List<Division> printOrganization() {
		List<Division>oList = mStore.selectOrganization(sqlSession);
		return oList;
	}
	//사원정보
	@Override
	public List<Member> printOrgInfo() {
		List<Member> mList = mStore.selectOrgInfo(sqlSession);
		return mList;
	}
	// 사원 조회 모달
	@Override
	public List<Member> modalPrintAll(String memberNum) {
		List<Member> mList = mStore.selectAllMember(sqlSession, memberNum);
		return mList;
	}
	
	// 사원 조회 모달 검색
	@Override
	public List<Member> modalPrintSearch(Search search) {
		List<Member> mList = mStore.selectMemberSearch(sqlSession, search);
		return mList;
	}
	
	// 채팅 사용자 추가 초대 모달
	@Override
	public List<Member> modalChatInvitePrint(int chatRoomNo) {
		List<Member> mList = mStore.selectAllChatMember(sqlSession, chatRoomNo);
		return mList;
	}
	
	// 채팅 사용자 추가 초대 모달 검색
	@Override
	public List<Member> modalChatInviteSearch(Search search) {
		List<Member> mList = mStore.selectAllChatMemberSearch(sqlSession, search);
		return mList;
	}
	
	// 넥사크로 - 관리자
	@Override
	public List<Member> printAllMember(Search search) { // 사원 전체 조회
		List<Member> mList = mStore.selectAllMemberNexa(sqlSession, search);
		return mList;
	}
	
	@Override
	public int registerMember(Member newMember) { // 사원 등록
		int result = mStore.insertMember(sqlSession, newMember);
		return result;
	}

	@Override
	public Member printOneMember(String memberNum) { // 사원 상세 조회
		Member member = mStore.selectOneMember(sqlSession, memberNum);
		return member;
	}

	@Override
	public int removeMember(String memberNum) { // 사원 삭제
		int result = mStore.deleteMember(sqlSession, memberNum);
		return result;
	}

	@Override
	public int modifyMember(Member newMember) { // 사원 정보 수정
		int result = mStore.updateMember(sqlSession, newMember);
		return result;
	}

	@Override
	public List<Division> printAllDivision() { // 부서 조회
		List<Division> dList = mStore.selectAllDivision(sqlSession);
		return dList;
	}

	@Override
	public List<Division> printOneDivision(String divCode) { // 부서 사원 조회
		List<Division> mList = mStore.selectOneDivision(sqlSession, divCode);
		return mList;
	}

}
