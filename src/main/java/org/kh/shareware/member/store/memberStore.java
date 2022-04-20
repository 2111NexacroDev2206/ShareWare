package org.kh.shareware.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;

public interface memberStore {

	public Member selectLoginMember(SqlSession session, Member member);

	public Member selectOneById(SqlSession session, String memberNum);

	public List<Member> selectAllMember(SqlSession session);
}
