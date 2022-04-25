package org.kh.shareware.community.service;

import java.util.List;

import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;

public interface CommunityService {

	int resisterCommunity(Community community);
	List<Community> listCommunity();
	Community detailCommunity(Integer comNo);
	int removeCommunity(int comNo);
	int viewCountCommunity(Integer comNo);
	int registerCommunityVote(CommunityVote communityVote);
	int removeCommunityVote(Integer comNo);

}
