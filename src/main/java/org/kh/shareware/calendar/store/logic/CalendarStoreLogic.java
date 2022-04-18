package org.kh.shareware.calendar.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.store.CalendarStore;

public class CalendarStoreLogic implements CalendarStore{

	@Override
	public int insertCalendar(Calendar calendar, SqlSession sqlSession) {
		int result = sqlSession.insert("", calendar);
		return result;
	}

}
