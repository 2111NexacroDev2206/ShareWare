
package org.kh.shareware.calendar.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;

public interface CalendarStore {

	

	public int insertSchedule(CalSch calSch, SqlSession sqlSession);

	public List<CalSch> selectAllSchedule(SqlSession sqlSession);

}
