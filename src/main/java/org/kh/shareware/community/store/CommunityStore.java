package org.kh.shareware.community.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;

public interface CommunityStore {

	int resisterCommunity(SqlSession sqlsession, Community community);

}
