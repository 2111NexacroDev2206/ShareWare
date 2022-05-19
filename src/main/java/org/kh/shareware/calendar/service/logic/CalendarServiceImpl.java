
package org.kh.shareware.calendar.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
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
	public int registerSchedule(CalSch calSch) {
		int result = cStore.insertSchedule(calSch, sqlSession);
		return result;
	}
	@Override
	public List<CalSch> printAllSchedule(CalSch calSch) {
		List<CalSch> sList = cStore.selectAllSchedule(calSch, sqlSession);
		return sList;
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

}
