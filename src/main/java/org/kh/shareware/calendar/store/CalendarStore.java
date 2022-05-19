
package org.kh.shareware.calendar.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;

public interface CalendarStore {

	
	//일정 등록
	public int insertSchedule(CalSch calSch, SqlSession sqlSession);
	//캘린더에 일정 목록 띄우기
	public List<CalSch> selectAllSchedule(CalSch calSch, SqlSession sqlSession);
	//일정 상세
	public CalSch selectOneSchedule(SqlSession sqlSession, int schNo);
	//일정 수정
	public int updateSchedule(CalSch calSch, SqlSession sqlSession);
	
	// 홈 - 일정
	public List<CalSch> selectCalList(SqlSession sqlSession, CalSch calSch);
	//내 캘린더 등록
	public int registerCalendar(Calendar calendar, SqlSession sqlSession);
	//내 캘린더 목록 조회
	public List<Calendar> selectCalMyList(SqlSession sqlSession, Calendar calendar);
	public int deleteCalendar(int calNo, SqlSession sqlSession);

}
