package org.kh.shareware.member.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.store.MemberStore;
import org.springframework.stereotype.Repository;

@Repository
public class MemberStoreLogic implements MemberStore{
	
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

	//주소록
	@Override
	public List<Member> selectAll(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getMemberLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> mList 
			= sqlSession.selectList("MemberMapper.selectAllList", pi, rowBounds);
		return mList;
	}
	@Override
	public int selectListCount(SqlSession sqlSession) {
		int totalCount = sqlSession.selectOne("MemberMapper.selectListCount");
		return totalCount;
	}
	
	@Override
	public List<Member> selectAllMember(SqlSession session) {
		List<Member> mList = session.selectList("MemberMapper.selectAllMember");
		return mList;
	}
	
	@Override
	public List<Member> selectMemberSearch(SqlSession session, Search search) {
		List<Member> mList = session.selectList("MemberMapper.selectMemberSearch", search);
		return mList;
	}
}
