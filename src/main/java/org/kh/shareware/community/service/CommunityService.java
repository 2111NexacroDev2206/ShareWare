package org.kh.shareware.community.service;

import java.util.List;
import java.util.Map;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;


public interface CommunityService {

	int registerCommunity(Community community);
	int searchComNo();
	int getListCount(String memberNum);
	List<Community> listCommunity(PageInfo pi, String memberNum);
	Community detailCommunity(Integer comNo);
	int removeCommunity(int comNo);
	int countViewCommunity(Integer comNo);
	
	
	
	
	
	int registerCommunityVote(CommunityVote communityVote);
	int removeCommunityVote(Integer comNo);
	CommunityVote detailCommunityVote(Integer comNo);
	CommunityVoteSelect viewCommunityVote(CommunityVoteSelect cVoteSelect);
	int endCommunityVote(Integer comNo);
	int registerCVoteSelect(CommunityVoteSelect cVoteSelect);
	int countCVoteSelect(Map<String, Object> map);
	int removeCVoteMember(Integer comNo);
	int modifyCommunity(Community community);
	void modifyCommunityVote(CommunityVote communityVote);
	

	int getSearchCount(Search search);
	List<Search> printSearchCommunity(PageInfo pi, Search search);
	List<Reply> printAllCommunityReply(int comNo);
	int registerReply(Reply reply);
	int deleteReply(Reply reply);
	void removeReplyAll(Integer comNo);
	int modifyReply(Reply reply);
	
	
	

	
	
	
	

}
