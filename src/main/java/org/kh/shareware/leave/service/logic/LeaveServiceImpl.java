package org.kh.shareware.leave.service.logic;


import org.apache.ibatis.session.SqlSession;
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
	

	


}
