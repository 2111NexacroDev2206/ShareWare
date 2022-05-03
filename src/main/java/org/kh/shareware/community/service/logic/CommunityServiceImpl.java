package org.kh.shareware.community.service.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.service.CommunityService;
import org.kh.shareware.community.store.CommunityStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired
	private CommunityStore cStore;
	@Autowired
	private SqlSession sqlsession;
	

	@Override
	public int searchComNo() {
		int result = cStore.selectComNo(sqlsession);
		return result;
	}
	
	@Override
	public int resisterCommunity(Community community) {
		int result = cStore.resisterCommunity(sqlsession, community);
		return result;
	}

	@Override
	public List<Community> listCommunity() {
		List<Community> cList = cStore.SelectAllCommunity(sqlsession);
		return cList;
	}
	
	@Override
	public int modifyCommunity(Community community) {
		int result = cStore.updateCommunity(sqlsession, community);
		return result;
	}


	@Override
	public Community detailCommunity(Integer comNo) {
		Community community = cStore.detailCommunity(sqlsession, comNo);
		return community;
	}

	@Override
	public int removeCommunity(int comNo) {
		int result = cStore.deleteCommunity(sqlsession, comNo);
		return result;
	}

	@Override
	public int viewCountCommunity(Integer comNo) {
		int result = cStore.viewCountCommunity(sqlsession, comNo);
		return result;
	}

	@Override
	public int registerCommunityVote(CommunityVote communityVote) {
		int result = cStore.insertCommunityVote(sqlsession,communityVote);
		return result;
	}

	@Override
	public int removeCommunityVote(Integer comNo) {
		int result = cStore.deleteCommunityVote(sqlsession,comNo);
		return result;
	}

	@Override
	public CommunityVote detailCommunityVote(Integer comNo) {
		CommunityVote communityVote = cStore.detailCommunityVote(sqlsession,comNo);
		return communityVote;
	}

	@Override
	public CommunityVoteSelect viewCommunityVote(Integer comNo) {
		CommunityVoteSelect cVoteSelect =cStore.selectVoteSelect(sqlsession, comNo);
		return cVoteSelect;
	}

	@Override
	public int endCommunityVote(Integer comNo) {
		int result = cStore.updateEndVote(sqlsession,comNo);
		return result;
	}

	@Override
	public int registerCVoteSelect(CommunityVoteSelect cVoteSelect) {
		int result = cStore.registerCVoteSelect(sqlsession, cVoteSelect);
		return result;
	}

	@Override
	public int countCVoteSelect(Map<String, Object> map) {
		int result = cStore.updateCountCVote(sqlsession, map);
		return result;
	}

	@Override
	public int removeCVoteMember(Integer comNo) {
		int result =cStore.removeCVoteMember(sqlsession, comNo);
		return result;
	}

	//투표 수정
	@Override
	public void modifyCommunityVote(CommunityVote communityVote) {
		cStore.updateCommunityVote(sqlsession,communityVote);
		
	}



}
