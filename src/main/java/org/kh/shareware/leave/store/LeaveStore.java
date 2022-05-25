package org.kh.shareware.leave.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.leave.domain.LeaveList;

public interface LeaveStore {

	//연차통계
	float selectLeaveUse(SqlSession sqlSession, String memNum);
	float selectLeaveTotal(SqlSession sqlSession, String memNum);
	//연차리스트
	List<LeaveList> selectAll(SqlSession sqlSession, String memNum);
	
	//넥사크로-연차조회
	List<LeaveList> selectAllLeaveNexa(SqlSession sqlSession, String inYear);
	List<LeaveList> selectAllSearchLeaveNexa(SqlSession sqlSession, Search search);




}
