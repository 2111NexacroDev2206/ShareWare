package org.kh.shareware.leave.service.logic;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.leave.domain.LeaveList;
import org.kh.shareware.leave.service.LeaveService;
import org.kh.shareware.leave.store.LeaveStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	private LeaveStore lStore;
	@Autowired
	private SqlSession sqlSession;
	
	
	//연차통계
	@Override
	public float printLeaveTotal(String memNum) {
		float result = lStore.selectLeaveTotal(sqlSession,memNum);
		return result;
	}
	@Override
	public float printLeaveUse(String memNum) {
		float result = lStore.selectLeaveUse(sqlSession,memNum);
		return result;
	}
	//연차리스트
	@Override
	public List<LeaveList> printAll(String memNum) {
		List<LeaveList>lList = lStore.selectAll(sqlSession,memNum);
		return lList;
	}
	
	//넥사크로-연차조회
	@Override
	public List<LeaveList> printAllLeave(String inYear) {
		List<LeaveList> lList = lStore.selectAllLeaveNexa(sqlSession, inYear);
		return lList;
	}
	@Override
	public List<LeaveList> printAllSearchLeave(Search search) {
		List<LeaveList> lList = lStore.selectAllSearchLeaveNexa(sqlSession, search);
		return lList;
	}
	

	


}
