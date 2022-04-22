package org.kh.shareware.community.service;

import java.util.List;

import org.kh.shareware.community.domain.Community;

public interface CommunityService {

	int resisterCommunity(Community community);
	List<Community> listCommunity();
	Community detailCommunity(Integer comNo);
	int removeCommunity(int comNo);
	int viewCountCommunity(Integer comNo);

}
