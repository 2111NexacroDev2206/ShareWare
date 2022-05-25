package org.kh.shareware.leave.store.logic;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.leave.domain.LeaveList;
import org.kh.shareware.leave.store.LeaveStore;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveStoreLogic implements LeaveStore{

	
	//연차통계
	@Override
	public float selectLeaveUse(SqlSession sqlSession, String memNum) {
		float result
		=sqlSession.selectOne("LeaveMapper.selectLeaveUse", memNum);
		return result;
	}
	@Override
	public float selectLeaveTotal(SqlSession sqlSession, String memNum) {
		float result
		=sqlSession.selectOne("LeaveMapper.selectLeaveTotal", memNum);
		return result;
	}
	//연차리스트
	@Override
	public List<LeaveList> selectAll(SqlSession sqlSession, String memNum) {
		List<LeaveList> lList 
		= sqlSession.selectList("LeaveMapper.selectAllList", memNum);
		return lList;
	}
	
	//넥사크로-연차리스트
	@Override
	public List<LeaveList> selectAllLeaveNexa(SqlSession sqlSession, String inYear) {
		List<LeaveList> lList = sqlSession.selectList("LeaveMapper.selectAllLeaveNexa", inYear);
		return lList;
	}
	@Override
	public List<LeaveList> selectAllSearchLeaveNexa(SqlSession sqlSession, Search search) {
		List<LeaveList> lList = sqlSession.selectList("LeaveMapper.selectAllSearchLeaveNexa", search);
		return lList;
	}



}
