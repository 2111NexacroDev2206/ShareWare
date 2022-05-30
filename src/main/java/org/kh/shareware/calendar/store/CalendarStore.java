
package org.kh.shareware.calendar.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;

public interface CalendarStore {

	
	//개인 일정 등록
	public int insertMySchedule(CalSch calSch, SqlSession sqlSession);
	//전사 일정 등록
	public int insertComSchedule(CalSch calSch, SqlSession sqlSession);
	//부서 일정 등록
	public int insertDeptSchedule(CalSch calSch, SqlSession sqlSession);
	//캘린더에 일정 목록 띄우기
	public List<CalSch> selectAllSchedule(CalSch calSch, SqlSession sqlSession);
	//전사일정 목록 띄우기
	public List<CalSch> selectAllComSchedule(CalSch calSch, SqlSession sqlSession);
	//일정 상세
	public CalSch selectOneSchedule(SqlSession sqlSession, int schNo);
	//일정 수정
	public int updateSchedule(CalSch calSch, SqlSession sqlSession);
	//일정 삭제
	public int deleteSchedule(int schNo, SqlSession sqlSession);
	//내 캘린더 등록
	public int registerCalendar(Calendar calendar, SqlSession sqlSession);
	//내 캘린더 목록 조회
	public List<Calendar> selectCalMyList(SqlSession sqlSession, Calendar calendar);
	public int deleteCalendar(int calNo, SqlSession sqlSession);
	
	// 홈 - 일정
	public List<CalSch> selectListHomeCal(SqlSession sqlSession, CalSch calSch); // 일정 목록

	public CalSch selectOneHomeCal(SqlSession sqlSession, int schNo); // 일정 상세

	public List<CalSch> selectAllHomeCal(SqlSession sqlSession, String memberNum); // 전체 일정 목록
	
	// 알림
	public CalSch selectLastCalSch(SqlSession sqlSession); // 최근 전사 일정 조회
	//내 캘린더 조회
	public List<CalSch> selectMyCalendar(int calNo, SqlSession sqlSession);
	
	

	

}
