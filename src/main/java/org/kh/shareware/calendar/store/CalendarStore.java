package org.kh.shareware.calendar.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.Calendar;

public interface CalendarStore {

	public int insertCalendar(Calendar calendar, SqlSession sqlSession);

}
