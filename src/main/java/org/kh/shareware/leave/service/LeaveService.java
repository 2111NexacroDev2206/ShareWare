package org.kh.shareware.leave.service;

public interface LeaveService {
	
	//근무통계
	float printLeaveTotal(String memNum);
	float printLeaveUse(String memNum);

	
}
