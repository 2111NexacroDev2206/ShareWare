package org.kh.shareware.community.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;
import org.kh.shareware.community.domain.Search;
import org.kh.shareware.community.store.CommunityStore;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityStoreLogic implements CommunityStore {
	
	//글등록
	@Override
	public int registerCommunity(SqlSession sqlsession, Community community) {
		int result = sqlsession.insert("CommnuityMapper.insertCommnuity",community);
		return result;
	}
	
	//글 번호 검색
	@Override
	public int selectComNo(SqlSession sqlsession) {
		int result =sqlsession.selectOne("CommnuityMapper.selectComNo");
		return result;
	}

	@Override
	public List<Community> SelectAllCommunity(SqlSession sqlsession) {
		List<Community> cList = sqlsession.selectList("CommnuityMapper.listCommnuity");
		return cList;
	}
	
	//상세보기
	@Override
	public Community detailCommunity(SqlSession sqlsession, Integer comNo) {
		Community community = sqlsession.selectOne("CommnuityMapper.detailOneByNo", comNo);
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
	public int viewCountCommunity(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.update("CommnuityMapper.viewCount", comNo);
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
	public CommunityVote detailCommunityVote(SqlSession sqlsession, Integer comNo) {
		CommunityVote communityVote = sqlsession.selectOne("CommnuityMapper.CommnuityVoteView", comNo);
		return communityVote;
	}

	@Override
	public CommunityVoteSelect selectVoteSelect(SqlSession sqlsession, Integer comNo) {
		CommunityVoteSelect cVoteSelect = sqlsession.selectOne("CommnuityMapper.selectCommnuityVote", comNo);
		return cVoteSelect;
	}
	
	@Override
	public int updateEndVote(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.update("CommnuityMapper.updateEndCommnuityVote", comNo);
		return result;
	}

	@Override
	public int registerCVoteSelect(SqlSession sqlsession, CommunityVoteSelect cVoteSelect) {
		int result = sqlsession.insert("CommnuityMapper.insertCVoteSelect",cVoteSelect);
		return result;
	}

	@Override
	public int updateCountCVote(SqlSession sqlsession, Map<String, Object> map) {
		int result = sqlsession.update("CommnuityMapper.updateCountCVote", map);
		return result;
	}

	@Override
	public int removeCVoteMember(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.delete("CommnuityMapper.deleteCVoteMember", comNo);
		return result;
	}

	@Override
	public void updateCommunityVote(SqlSession sqlsession, CommunityVote communityVote) {
		sqlsession.update("CommnuityMapper.uqdateCommunityVote", communityVote);
		
	}

	//검색
	@Override
	public List<Search> selectSearchCommunity(SqlSession sqlsession, Search search) {
		List<Search> scList = sqlsession.selectList("CommnuityMapper.searchCommunity", search);
		return scList;
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

	



	

}
