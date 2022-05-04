
package org.kh.shareware.calendar.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.store.CalendarStore;
import org.springframework.stereotype.Repository;

@Repository
public class CalendarStoreLogic implements CalendarStore{



	@Override
	public int insertSchedule(CalSch calSch, SqlSession sqlSession) {
		int result = sqlSession.insert("CalendarMapper.insertSchedule", calSch);
		return result;
	}

	@Override
	public List<CalSch> selectAllSchedule(SqlSession sqlSession) {
		List<CalSch> sList = sqlSession.selectList("CalendarMapper.selectAllSchedule");
		return sList;
	}

}
