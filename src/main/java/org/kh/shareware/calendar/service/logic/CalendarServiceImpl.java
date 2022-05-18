
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
	public List<CalSch> selectCalList(CalSch calSch) {
		List<CalSch> cList = cStore.selectCalList(sqlSession, calSch);
		return cList;
	}

}
