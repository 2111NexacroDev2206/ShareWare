
package org.kh.shareware.calendar.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.service.CalendarService;
import org.kh.shareware.calendar.store.CalendarStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	CalendarStore cStore;
	@Autowired
	SqlSession sqlSession;
	



	@Override
	public int registerMySchedule(CalSch calSch) {
		int mResult = cStore.insertMySchedule(calSch, sqlSession);
		return mResult;
	}
	@Override
	public int registerComSchedule(CalSch calSch) {
		int cResult = cStore.insertComSchedule(calSch, sqlSession);
		return cResult;
	}
	@Override
	public int registerDeptSchedule(CalSch calSch) {
		int dResult = cStore.insertDeptSchedule(calSch, sqlSession);
		return dResult;
	}
	
	@Override
	public List<CalSch> printAllSchedule(CalSch calSch) {
		List<CalSch> sList = cStore.selectAllSchedule(calSch, sqlSession);
		return sList;
	}
	@Override
	public List<CalSch> printAllComSchedule(CalSch calSch) {
		List<CalSch> cList = cStore.selectAllComSchedule(calSch, sqlSession);
		return cList;
	}
	@Override
	public CalSch printOneSchedule(int schNo) {
		CalSch calSch = cStore.selectOneSchedule(sqlSession, schNo);
		return calSch;
	}
	@Override
	public int modifySchedule(CalSch calSch) {
		int result = cStore.updateSchedule(calSch, sqlSession);
		return result;
	}
	@Override
	public int deleteSchedule(int schNo) {
		int result = cStore.deleteSchedule(schNo, sqlSession);
		return result;
	}
	@Override
	public int registerCalendar(Calendar calendar) {
		int result = cStore.registerCalendar(calendar, sqlSession);
		return result;
	}
	@Override
	public List<Calendar> printAllMyCalendar(Calendar calendar) {
		List<Calendar> cList = cStore.selectCalMyList(sqlSession, calendar);
		return cList;
	}
	@Override
	public int deleteCalendar(int calNo) {
		int result = cStore.deleteCalendar(calNo, sqlSession);
		return result;
	}
	// 홈 - 일정
	@Override
	public List<CalSch> printListHomeCal(CalSch calSch) { // 일정 목록
		List<CalSch> cList = cStore.selectListHomeCal(sqlSession, calSch);
		return cList;
	}
	@Override
	public CalSch printOneHomeCal(int schNo) { // 일정 상세
		CalSch calSch = cStore.selectOneHomeCal(sqlSession, schNo);
		return calSch;
	}
	@Override
	public List<CalSch> printAllHomeCal(String memberNum) { // 전체 일정 목록
		List<CalSch> sList = cStore.selectAllHomeCal(sqlSession, memberNum);
		return sList;
	}
	
	// 알림
	@Override
	public CalSch printLastCalSch() { // 최근 전사 일정 조회
		CalSch calSch = cStore.selectLastCalSch(sqlSession);
		return calSch;
	}
	@Override
	public List<CalSch> printMyCalendar(int calNo) {
		List<CalSch> cList = cStore.selectMyCalendar(calNo, sqlSession);
		return cList;
	}
	
	

}
