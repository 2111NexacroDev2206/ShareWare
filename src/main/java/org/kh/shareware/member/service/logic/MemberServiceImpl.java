package org.kh.shareware.member.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.domain.PageInfo;
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
	
	@Override
	public List<Member> modalPrintAll() {
		List<Member> mList = mStore.selectAllMember(sqlSession);
		return mList;
	}

	@Override
	public List<Member> modalPrintSearch(Search search) {
		List<Member> mList = mStore.selectMemberSearch(sqlSession, search);
		return mList;
	}
	
	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> printAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
