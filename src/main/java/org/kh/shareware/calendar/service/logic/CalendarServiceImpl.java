
package org.kh.shareware.calendar.service.logic;

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

}
