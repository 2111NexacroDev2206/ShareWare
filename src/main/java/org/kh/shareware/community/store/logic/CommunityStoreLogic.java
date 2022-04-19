package org.kh.shareware.community.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.store.CommunityStore;

public class CommunityStoreLogic implements CommunityStore {

	@Override
	public int resisterCommunity(SqlSession sqlsession, Community community) {
		int result = sqlsession.insert("CommnuityMapper.insertCommnuity",community);
		return result;
	}

}
