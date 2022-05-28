package org.kh.shareware.attendance.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.common.Search;

public interface AttendanceStore {
	//등록
	public int insertAttendance(SqlSession sqlSession, Attendance attendance);
	public int updateAttendance(SqlSession sqlSession, Attendance attendance);

	//근태리스트
	List<Attendance> selectAll(SqlSession sqlSession, String memNum);
	public int selectListCount(SqlSession sqlSession, String memNum);
	
	//통계
	public List<Stats> selectStats(SqlSession sqlSession, String memNum);
	
	// 홈 - 근태 관리
	public Attendance selectOneAtt(SqlSession sqlSession, String memberNum);
	
	//넥사크로-근태관리
	public List<Attendance> selectAllAttNexa(SqlSession sqlSession, String inVar);
	//검색
	public List<Attendance> selectAllSearchAttNexa(SqlSession sqlSession, Search search);
	//통계
	public List<Stats> selectStatsNexa(SqlSession sqlSession, String inVar);

}
