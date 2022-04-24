package org.kh.shareware.community.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;

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

}
