package org.kh.shareware.community.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;

public interface CommunityStore {
	
	//자유게시판 글작성
	int resisterCommunity(SqlSession sqlsession, Community community);
	//자유게시판 리스트 보기
	List<Community> listCommunity(SqlSession sqlsession);
	//자유게시판 상세보기
	Community detailCommunity(SqlSession sqlsession, Integer comNo);
	int resisterCommunity(SqlSession sqlsession, int comNo);
	int viewCountCommunity(SqlSession sqlsession, Integer comNo);
	int insertCommunityVote(SqlSession sqlsession, CommunityVote communityVote);
	int removeCommunityVote(SqlSession sqlsession, Integer comNo);
	CommunityVote deleteCommunityVote(SqlSession sqlsession, Integer comNo);
	CommunityVoteSelect selectVoteSelect(SqlSession sqlsession, Integer comNo);
	int updateAndVote(SqlSession sqlsession, Integer comNo);


}
