package org.kh.shareware.community.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;

public interface CommunityStore {
	
	//자유게시판 글작성
	int registerCommunity(SqlSession sqlsession, Community community);
	int selectComNo(SqlSession sqlsession);
	//전체 게시글의 개수
	int selectClistCount(SqlSession sqlsession, String memberNum);
	//자유게시판 리스트 보기
	List<Community> selectAllCommunity(SqlSession sqlsession, PageInfo pi, String memerNum);
	//자유게시판 상세보기
	Community selectOneCommunity(SqlSession sqlsession, Integer comNo);
	int updateCommunity(SqlSession sqlsession, Community community);
	int deleteCommunity(SqlSession sqlsession, int comNo);
	int countViewCommunity(SqlSession sqlsession, Integer comNo);
	int insertCommunityVote(SqlSession sqlsession, CommunityVote communityVote);
	int deleteCommunityVote(SqlSession sqlsession, Integer comNo);
	CommunityVote detailCommunityVote(SqlSession sqlsession, Integer comNo);
	CommunityVoteSelect selectVoteSelect(SqlSession sqlsession, Integer comNo);
	int updateEndVote(SqlSession sqlsession, Integer comNo);
	int registerCVoteSelect(SqlSession sqlsession, CommunityVoteSelect cVoteSelect);
	int updateCountCVote(SqlSession sqlsession, Map<String, Object> map);
	int removeCVoteMember(SqlSession sqlsession, Integer comNo);
	void updateCommunityVote(SqlSession sqlsession, CommunityVote communityVote);
	
	//전체 검색된 글 개수
	int selectSearchCount(SqlSession sqlsession, Search search);
	//검색
	List<Search> selectSearchCommunity(SqlSession sqlsession,  PageInfo pi, Search search);
	//댓글
	List<Reply> selectCommunityReply(SqlSession sqlsession, int comNo);
	//댓글 등록
	int insertReply(SqlSession sqlsession, Reply reply);
	//자신이쓴 댓글만 삭제
	int deleteReply(SqlSession sqlsession, Reply reply);
	//댓글 전체삭제
	int deleteAllReply(SqlSession sqlsession, Integer comNo);
	//댓글 수정
	int updateReply(SqlSession sqlsession, Reply reply);
	

	
	
	
	


}
