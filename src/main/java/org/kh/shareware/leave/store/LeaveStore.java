package org.kh.shareware.leave.store;

import org.apache.ibatis.session.SqlSession;

public interface LeaveStore {

	//연차통계
	float selectLeaveUse(SqlSession sqlSession, String memNum);
	float selectLeaveTotal(SqlSession sqlSession, String memNum);




}
