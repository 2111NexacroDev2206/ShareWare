package org.kh.shareware.attendance.service;

import java.util.List;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.member.common.PageInfo;

public interface AttendanceService {

	//출퇴근 버튼
	int registerAttendance(Attendance attendance);
	int modifyAttendance(Attendance attendance);
	
	//근태리스트
	int getListCount(String memNum);
	List<Attendance> printAll(PageInfo pi, String memNum);
	
	//통계
	List<Stats> printStats(String memNum);
	
	//근태리스트 재설정
	//void searchAttendanceList(String date);
	
	// 홈 - 근태 관리
	public Attendance homeAttTime(String memberNum);
	
}
