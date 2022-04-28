package org.kh.shareware.attendance.service;

import java.util.List;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.member.common.PageInfo;

public interface AttendanceService {

	//출퇴근
	int registerAttendance(Attendance attendance);
	int modifyAttendance(Attendance attendance);
	
	int getListCount(String memNum);
	List<Attendance> printAll(PageInfo pi, String memNum);



}
