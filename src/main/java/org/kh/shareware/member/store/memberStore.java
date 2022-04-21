package org.kh.shareware.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.domain.PageInfo;
import org.mybatis.spring.SqlSessionTemplate;

public interface memberStore {

	public Member selectLoginMember(SqlSession session, Member member);

	public Member selectOneById(SqlSession session, String memberNum);

	//주소록
	public List<Member> selectAll(SqlSessionTemplate sqlSession, PageInfo pi);
	public int selectListCount(SqlSessionTemplate sqlSession);
}
