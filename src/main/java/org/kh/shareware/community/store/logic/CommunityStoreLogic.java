package org.kh.shareware.community.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.store.CommunityStore;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityStoreLogic implements CommunityStore {

	@Override
	public int resisterCommunity(SqlSession sqlsession, Community community) {
		int result = sqlsession.insert("CommnuityMapper.insertCommnuity",community);
		return result;
	}

	@Override
	public List<Community> listCommunity(SqlSession sqlsession) {
		List<Community> cList = sqlsession.selectList("CommnuityMapper.listCommnuity");
		return cList;
	}

	@Override
	public Community detailCommunity(SqlSession sqlsession, Integer comNo) {
		Community community = sqlsession.selectOne("CommnuityMapper.detailOneByNo", comNo);
		return community;
	}

	@Override
	public int resisterCommunity(SqlSession sqlsession, int comNo) {
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
	public int removeCommunityVote(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.delete("CommnuityMapper.deleteCommnuityVote", comNo);
		return result;
	}

	@Override
	public CommunityVote deleteCommunityVote(SqlSession sqlsession, Integer comNo) {
		CommunityVote communityVote = sqlsession.selectOne("CommnuityMapper.CommnuityVoteView", comNo);
		return communityVote;
	}

	@Override
	public CommunityVoteSelect selectVoteSelect(SqlSession sqlsession, Integer comNo) {
		CommunityVoteSelect cVoteSelect = sqlsession.selectOne("CommnuityMapper.selectCommnuityVote", comNo);
		return cVoteSelect;
	}

	@Override
	public int updateAndVote(SqlSession sqlsession, Integer comNo) {
		int result = sqlsession.update("CommnuityMapper.updateAndCommnuityVote", comNo);
		return result;
	}
}
