package org.kh.shareware.attendance.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.attendance.store.AttendanceStore;
import org.kh.shareware.common.Search;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	//출퇴근 등록
	@Override
	public int insertAttendance(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.insert("AttendanceMapper.insertAttendance", attendance);
		return result;
	}
	@Override
	public int updateAttendance(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.update("AttendanceMapper.updateAttendance", attendance);
		return result;
	}

	//근태리스트
	@Override
	public List<Attendance> selectAll(SqlSession sqlSession, String memNum) {
		List<Attendance> aList 
			= sqlSession.selectList("AttendanceMapper.selectAllList", memNum);
		return aList;
	}
	@Override
	public int selectListCount(SqlSession sqlSession, String memNum) {
		int totalCount = sqlSession.selectOne("AttendanceMapper.selectListCount",memNum);
		return totalCount;
	}
	
	//통계
	@Override
	public List<Stats> selectStats(SqlSession sqlSession, String memNum) {
		List<Stats> sList 
		= sqlSession.selectList("AttendanceMapper.selectStats", memNum);
	return sList;
	}
	
	// 홈 - 근태 관리
	@Override
	public Attendance selectOneAtt(SqlSession sqlSession, String memberNum) {
		Attendance attendance = sqlSession.selectOne("AttendanceMapper.selectOneAtt", memberNum);
		return attendance;
	}
	
	//넥사크로-근태관리
	@Override
	public List<Attendance> selectAllAttNexa(SqlSession sqlSession, String inVar) {
		List<Attendance> aList = sqlSession.selectList("AttendanceMapper.selectAllAttNexa", inVar);
		return aList;
	}
	//넥사크로-근태관리 검색
	@Override
	public List<Attendance> selectAllSearchAttNexa(SqlSession sqlSession, Search search) {
		List<Attendance> aList = sqlSession.selectList("AttendanceMapper.selectAllSearchAttNexa", search);
		return aList;
	}
	//넥사크로-근태통계
	@Override
	public List<Stats> selectStatsNexa(SqlSession sqlSession, String inVar) {
		List<Stats> sList = sqlSession.selectList("AttendanceMapper.selecAttStsNexa", inVar);
		return sList;
	}


}
