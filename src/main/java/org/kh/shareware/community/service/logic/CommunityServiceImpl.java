package org.kh.shareware.community.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
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
	public int resisterCommunity(Community community) {
		int result = cStore.resisterCommunity(sqlsession, community);
		return result;
	}

	@Override
	public List<Community> listCommunity() {
		List<Community> cList = cStore.listCommunity(sqlsession);
		return cList;
	}

	@Override
	public Community detailCommunity(Integer comNo) {
		Community community = cStore.detailCommunity(sqlsession, comNo);
		return community;
	}

	@Override
	public int removeCommunity(int comNo) {
		int result = cStore.resisterCommunity(sqlsession, comNo);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
