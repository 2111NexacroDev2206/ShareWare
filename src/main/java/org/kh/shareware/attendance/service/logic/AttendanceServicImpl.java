package org.kh.shareware.attendance.service.logic;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.attendance.store.AttendanceStore;
import org.kh.shareware.common.Search;
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
	@Override
	public int modifyAttendance(Attendance attendance) {
		int result = aStore.updateAttendance(sqlSession,attendance);
		return result;
	}

	//근태 리스트
	@Override
	public List<Attendance> printAll(String memNum) {
		List<Attendance> aList = aStore.selectAll(sqlSession, memNum);
		return aList;
	}
	@Override
	public int getListCount(String memNum) {
		int totalCount = aStore.selectListCount(sqlSession,memNum);
		return totalCount;
	}
	
	//통계
	@Override
	public List<Stats> printStats(String memNum) {
		List<Stats> sList = aStore.selectStats(sqlSession, memNum);
		return sList;
	}
	
	// 홈 - 근태 관리
	@Override
	public Attendance homeAttTime(String memberNum) {
		Attendance attendance = aStore.selectOneAtt(sqlSession, memberNum);
		return attendance;
	}
	
	
	//넥사크로-근태관리
	@Override
	public List<Attendance> printAllAtt(String inVar) {
		List<Attendance> aList = aStore.selectAllAttNexa(sqlSession, inVar);
		return aList;
	}
	//넥사크로-근태관리 검색
	@Override
	public List<Attendance> printAllSearchAtt(Search search) {
		List<Attendance> aList = aStore.selectAllSearchAttNexa(sqlSession,search);
		return aList;
	}
	//넥사크로-근태통계
	@Override
	public List<Stats> printAttStats(String inVar) {
		List<Stats> sList = aStore.selectStatsNexa(sqlSession, inVar);
		return sList;
	}

}
