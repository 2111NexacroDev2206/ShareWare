package org.kh.shareware.community.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
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
}
