package org.kh.shareware.community.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;

public interface CommunityStore {
	
	//자유게시판 글작성
	int resisterCommunity(SqlSession sqlsession, Community community);
	int selectComNo(SqlSession sqlsession);
	//자유게시판 리스트 보기
	List<Community> SelectAllCommunity(SqlSession sqlsession);
	//자유게시판 상세보기
	Community detailCommunity(SqlSession sqlsession, Integer comNo);
	int updateCommunity(SqlSession sqlsession, Community community);
	int deleteCommunity(SqlSession sqlsession, int comNo);
	int viewCountCommunity(SqlSession sqlsession, Integer comNo);
	int insertCommunityVote(SqlSession sqlsession, CommunityVote communityVote);
	int deleteCommunityVote(SqlSession sqlsession, Integer comNo);
	CommunityVote detailCommunityVote(SqlSession sqlsession, Integer comNo);
	CommunityVoteSelect selectVoteSelect(SqlSession sqlsession, Integer comNo);
	int updateEndVote(SqlSession sqlsession, Integer comNo);
	int registerCVoteSelect(SqlSession sqlsession, CommunityVoteSelect cVoteSelect);
	int updateCountCVote(SqlSession sqlsession, Map<String, Object> map);
	int removeCVoteMember(SqlSession sqlsession, Integer comNo);
	void updateCommunityVote(SqlSession sqlsession, CommunityVote communityVote);
	
	


}
