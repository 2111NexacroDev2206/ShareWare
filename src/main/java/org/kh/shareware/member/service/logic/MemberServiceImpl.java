package org.kh.shareware.member.service.logic;

import java.util.List;
import java.util.Map;

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
	public List<Member> printAllSearch(PageInfo pi) {
		List<Member> mList = mStore.selectAllSearch(sqlSession, pi);
		return mList;
	}
	//검색 페이징
	@Override
	public int getListCountSearch() {
		int totalCount = mStore.selectListCountSearch(sqlSession);
		return totalCount;
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

	//사원등록
	@Override
	public int insertMem(Map<Object, String> paramMap) {
		return mStore.regisgterMem(sqlSession, paramMap);
	}

}
