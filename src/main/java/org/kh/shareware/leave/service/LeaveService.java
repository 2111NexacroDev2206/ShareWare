package org.kh.shareware.leave.service;

import java.util.List;

import org.kh.shareware.leave.domain.LeaveList;

public interface LeaveService {
	
	//근무통계
	float printLeaveTotal(String memNum);
	float printLeaveUse(String memNum);
	//연차리스트
	List<LeaveList> printAll(String memNum);

	
}
