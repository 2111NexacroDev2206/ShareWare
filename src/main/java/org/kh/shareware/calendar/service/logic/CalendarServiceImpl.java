package org.kh.shareware.calendar.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.service.CalendarService;
import org.kh.shareware.calendar.store.CalendarStore;
import org.springframework.beans.factory.annotation.Autowired;

public class CalendarServiceImpl implements CalendarService{

	@Autowired
	CalendarStore cStore;
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int registerCalendar(Calendar calendar) {
		int result = cStore.insertCalendar(calendar, sqlSession);
		return result;
	}

}
