package org.kh.shareware.member.service.logic;

import java.util.List;

import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.service.MemberService;
import org.kh.shareware.member.store.MemberStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
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

	
}
