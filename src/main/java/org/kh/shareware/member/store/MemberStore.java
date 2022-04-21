package org.kh.shareware.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
<<<<<<< HEAD
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Member;

public interface MemberStore {

	public Member selectLoginMember(SqlSession session, Member member);

	public Member selectOneById(SqlSession session, String memberNum);

	//주소록
	public List<Member> selectAll(SqlSession sqlSession, PageInfo pi);
	public int selectListCount(SqlSession sqlSession);
	
	public List<Member> selectAllMember(SqlSession session);
	public List<Member> selectMemberSearch(SqlSession session, Search search);
=======
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.domain.PageInfo;

public interface MemberStore {

	public Member selectLoginMember(SqlSession session, Member member);

	public Member selectOneById(SqlSession session, String memberNum);

	public List<Member> selectAllMember(SqlSession session);
	public List<Member> selectMemberSearch(SqlSession session, Search search);

	//주소록
	public List<Member> selectAll(SqlSession sqlSession, PageInfo pi);
	public int selectListCount(SqlSession sqlSession);

>>>>>>> refs/heads/master
}
