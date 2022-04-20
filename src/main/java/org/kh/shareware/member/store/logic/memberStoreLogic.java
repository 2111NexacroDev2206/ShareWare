package org.kh.shareware.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.store.memberStore;
import org.springframework.stereotype.Repository;

@Repository
public class memberStoreLogic implements memberStore{
	
	//로그인
	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		Member memberOne = session.selectOne("MemberMapper.selectLoginMember", member);
		return memberOne;
	}
	
	//마이페이지
	@Override
	public Member selectOneById(SqlSession session, String memberNum) {
		Member memberOne = session.selectOne("MemberMapper.selectOneById",memberNum);
		return memberOne;
	}
}
