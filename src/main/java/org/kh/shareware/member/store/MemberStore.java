package org.kh.shareware.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Member;

public interface MemberStore {

	public Member selectLoginMember(SqlSession session, Member member);

	public Member selectOneById(SqlSession session, String memberNum);

	//주소록
	public List<Member> selectAll(SqlSession sqlSession, PageInfo pi);
	public int selectListCount(SqlSession sqlSession);
}
