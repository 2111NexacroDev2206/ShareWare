package org.kh.shareware.attendance.service;

import java.util.List;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.member.common.PageInfo;

public interface AttendanceService {

	int registerAttendance(Attendance attendance);

	int getListCount();
	List<Attendance> printAll(PageInfo pi);

}
