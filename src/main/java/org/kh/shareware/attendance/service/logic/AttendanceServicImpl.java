package org.kh.shareware.attendance.service.logic;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.attendance.store.AttendanceStore;
import org.kh.shareware.member.common.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServicImpl implements AttendanceService{

	@Autowired
	private AttendanceStore aStore;
	@Autowired
	private SqlSession sqlSession;
	
	//등록
	@Override
	public int registerAttendance(Attendance attendance) {
		int result = aStore.insertAttendance(sqlSession,attendance);
		return result;
	}

	//근태 리스트
	@Override
	public int getListCount() {
		int totalCount = aStore.selectListCount(sqlSession);
		return totalCount;
	}
	@Override
	public List<Attendance> printAll(PageInfo pi) {
		List<Attendance> aList = aStore.selectAll(sqlSession, pi);
		return aList;
	}

}
