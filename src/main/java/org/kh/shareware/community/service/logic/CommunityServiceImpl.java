package org.kh.shareware.community.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.service.CommunityService;
import org.kh.shareware.community.store.CommunityStore;
import org.springframework.beans.factory.annotation.Autowired;

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

}
