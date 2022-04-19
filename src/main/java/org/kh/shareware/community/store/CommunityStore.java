package org.kh.shareware.community.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;

public interface CommunityStore {

	int resisterCommunity(SqlSession sqlsession, Community community);
	List<Community> listCommunity(SqlSession sqlsession);

}
