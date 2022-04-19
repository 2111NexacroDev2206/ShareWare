package org.kh.shareware.calendar.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;

public interface CalendarStore {

	

	public int insertSchedule(CalSch calSch, SqlSession sqlSession);

}
