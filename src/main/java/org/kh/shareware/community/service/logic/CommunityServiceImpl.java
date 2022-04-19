package org.kh.shareware.community.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
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
}
