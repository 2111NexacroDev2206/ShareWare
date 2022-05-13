package org.kh.shareware.community.service.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;
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
	public int searchComNo() {
		int result = cStore.selectComNo(sqlsession);
		return result;
	}
	
	@Override
	public int registerCommunity(Community community) {
		int result = cStore.registerCommunity(sqlsession, community);
		return result;
	}
	
	//전체 게시물의 개수
	@Override
	public int getListCount() {
		int result = cStore.selectClistCount(sqlsession);
		return result;
	}
	
	@Override
	public List<Community> listCommunity(PageInfo pi) {
		List<Community> cList = cStore.selectAllCommunity(sqlsession, pi);
		return cList;
	}
	
	@Override
	public int modifyCommunity(Community community) {
		int result = cStore.updateCommunity(sqlsession, community);
		return result;
	}


	@Override
	public Community detailCommunity(Integer comNo) {
		Community community = cStore.selectOneCommunity(sqlsession, comNo);
		return community;
	}

	@Override
	public int removeCommunity(int comNo) {
		int result = cStore.deleteCommunity(sqlsession, comNo);
		return result;
	}

	@Override
	public int countViewCommunity(Integer comNo) {
		int result = cStore.countViewCommunity(sqlsession, comNo);
		return result;
	}

	@Override
	public int registerCommunityVote(CommunityVote communityVote) {
		int result = cStore.insertCommunityVote(sqlsession,communityVote);
		return result;
	}

	@Override
	public int removeCommunityVote(Integer comNo) {
		int result = cStore.deleteCommunityVote(sqlsession,comNo);
		return result;
	}

	@Override
	public CommunityVote detailCommunityVote(Integer comNo) {
		CommunityVote communityVote = cStore.detailCommunityVote(sqlsession,comNo);
		return communityVote;
	}

	@Override
	public CommunityVoteSelect viewCommunityVote(Integer comNo) {
		CommunityVoteSelect cVoteSelect =cStore.selectVoteSelect(sqlsession, comNo);
		return cVoteSelect;
	}

	@Override
	public int endCommunityVote(Integer comNo) {
		int result = cStore.updateEndVote(sqlsession,comNo);
		return result;
	}

	@Override
	public int registerCVoteSelect(CommunityVoteSelect cVoteSelect) {
		int result = cStore.registerCVoteSelect(sqlsession, cVoteSelect);
		return result;
	}

	@Override
	public int countCVoteSelect(Map<String, Object> map) {
		int result = cStore.updateCountCVote(sqlsession, map);
		return result;
	}


	@Override
	public int removeCVoteMember(Integer comNo) {
		int result =cStore.removeCVoteMember(sqlsession, comNo);
		return result;
	}

	//투표 수정
	@Override
	public void modifyCommunityVote(CommunityVote communityVote) {
		cStore.updateCommunityVote(sqlsession,communityVote);
		
	}
	//글검색 개수
	@Override
	public int getSearchCount(Search search) {
		int result = cStore.selectSearchCount(sqlsession, search);
		return result;
	}

	//검색
	@Override
	public List<Search> printSearchCommunity(Search search, PageInfo pi) {
		List<Search> cList = cStore.selectSearchCommunity(sqlsession, search, pi);
		return cList;
	}

	@Override
	public List<Reply> printAllCommunityReply(int comNo) {
		List<Reply> cReplyList = cStore.selectCommunityReply(sqlsession, comNo);
		return cReplyList;
	}
	
	//댓글등록
	@Override
	public int registerReply(Reply reply) {
		int result = cStore.insertReply(sqlsession, reply);
		return result;
	}
	//자신이 쓴 댓글 삭제
	@Override
	public int deleteReply(Reply reply) {
		int result = cStore.deleteReply(sqlsession, reply);
		return result;
	}
	//전채 댓글 삭제
	@Override
	public void removeReplyAll(Integer comNo) {
		cStore.deleteAllReply(sqlsession, comNo);

	}

	//댓글 수정
	@Override
	public int modifyReply(Reply reply) {
		int result = cStore.updateReply(sqlsession, reply);
		return result;
	}	
	

}
