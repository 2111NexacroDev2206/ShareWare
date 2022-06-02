package org.kh.shareware.community.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;
import org.kh.shareware.community.store.CommunityStore;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityStoreLogic implements CommunityStore {
	
	//글등록
	@Override
	public int insertCommunity(SqlSession sqlsession, Community community) {
		int result = sqlsession.insert("CommnuityMapper.insertCommnuity",community);
		return result;
	}
	
	//글 번호 검색
	@Override
	public int selectComNo(SqlSession sqlsession) {
		int result =sqlsession.selectOne("CommnuityMapper.selectComNo");
		return result;
	}
	//전체 게시물의 개수
	@Override
	public int selectClistCount(SqlSession sqlsession, String memberNum) {
		int totalCount =sqlsession.selectOne("CommnuityMapper.selectClistCount",memberNum);
		return totalCount;
	}

	@Override
	public List<Community> selectAllCommunity(SqlSession sqlsession, PageInfo pi, String MemberNum) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Community> cList = sqlsession.selectList("CommnuityMapper.listCommnuity", MemberNum, rowBounds);
		return cList;
	}
	
	//상세보기
	@Override
	public Community selectOneCommunity(SqlSession sqlsession, Integer comNo) {
		Community community = sqlsession.selectOne("CommnuityMapper.selectOneCommunity", comNo);
		return community;
	}
	//수정
	@Override
	public int updateCommunity(SqlSession sqlsession, Community community) {
		int result = sqlsession.update("CommnuityMapper.updateCommunity", community);
		return result;
	}
	
	//삭제
	@Override
	public int deleteCommunity(SqlSession sqlsession, int comNo) {
		int result = sqlsession.delete("CommnuityMapper.deleltCommunity", comNo);
		return result;
	}

	@Override
	public int countViewCommunity(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.update("CommnuityMapper.countViewCommunity", comNo);
		return result;
	}

	@Override
	public int insertCommunityVote(SqlSession sqlsession, CommunityVote communityVote) {
		int result = sqlsession.insert("CommnuityMapper.insertCommnuityVote", communityVote);
		return result;
	}

	@Override
	public int deleteCommunityVote(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.delete("CommnuityMapper.deleteCommnuityVote", comNo);
		return result;
	}

	@Override
	public CommunityVote selectCommunityVote(SqlSession sqlsession, Integer comNo) {
		CommunityVote communityVote = sqlsession.selectOne("CommnuityMapper.CommnuityVoteView", comNo);
		return communityVote;
	}

	@Override
	public CommunityVoteSelect selectVoteSelectMember(SqlSession sqlsession, CommunityVoteSelect voteSelect) {
		CommunityVoteSelect cVoteSelect = sqlsession.selectOne("CommnuityMapper.selectCommnuityVoteMember", voteSelect);
		return cVoteSelect;
	}
	
	
	@Override
	public int updateEndVote(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.update("CommnuityMapper.updateEndCommnuityVote", comNo);
		return result;
	}

	@Override
	public int insertCVoteSelect(SqlSession sqlsession, CommunityVoteSelect cVoteSelect) {
		int result = sqlsession.insert("CommnuityMapper.insertCVoteSelect",cVoteSelect);
		return result;
	}
	
	@Override
	public int updateCountCVote(SqlSession sqlsession, Map<String, Object> map) {
		int result = sqlsession.update("CommnuityMapper.updateCountCVote", map);
		return result;
	}

	@Override
	public int deleteCVoteMember(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.delete("CommnuityMapper.deleteCVoteMember", comNo);
		return result;
	}

	@Override
	public void updateCommunityVote(SqlSession sqlsession, CommunityVote communityVote) {
		sqlsession.update("CommnuityMapper.uqdateCommunityVote", communityVote);
		
	}
	
	//전체 검색 된 글 개수
	@Override
	public int selectSearchCount(SqlSession sqlsession, Search search) {
		int result = sqlsession.selectOne("CommnuityMapper.selectSearchCount",search);
		return result;
	}

	//검색
	@Override
	public List<Search> selectSearchCommunity(SqlSession sqlsession, PageInfo pi, Search search) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Search> cList = sqlsession.selectList("CommnuityMapper.searchCommunity", search, rowBounds);
		return cList;
	}
	//덧글 출력
	@Override
	public List<Reply> selectCommunityReply(SqlSession sqlsession, int comNo) {
		List<Reply> cReplyList =sqlsession.selectList("CommnuityMapper.selectReplyList",comNo);
		return cReplyList;
	}
	//덧글 등록
	@Override
	public int insertReply(SqlSession sqlsession, Reply reply) {
		int result = sqlsession.insert("CommnuityMapper.insertReply", reply);
		return result;
	}

	@Override
	public int deleteReply(SqlSession sqlsession, Reply reply) {
		int result = sqlsession.delete("CommnuityMapper.deleteReply", reply);
		return result;
	}

	@Override
	public int deleteAllReply(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.delete("CommnuityMapper.deleteAllReply", comNo);
		return result;
	}
	
	//댓글 수정
	@Override
	public int updateReply(SqlSession sqlsession, Reply reply) {
		int result = sqlsession.update("CommnuityMapper.updateReply", reply);
		return result;
	}


	
}
