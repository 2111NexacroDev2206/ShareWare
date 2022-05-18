
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
	public List<CalSch> selectAllSchedule(CalSch calSch, SqlSession sqlSession) {
		List<CalSch> sList = sqlSession.selectList("CalendarMapper.selectAllSchedule", calSch);
		return sList;
	}

	@Override
	public CalSch selectOneSchedule(SqlSession sqlSession, int schNo) {
		CalSch calSch = sqlSession.selectOne("CalendarMapper.selectOneSchedule", schNo);
		return calSch;
	}
	
	@Override
	public int updateSchedule(CalSch calSch, SqlSession sqlSession) {
		int result = sqlSession.update("CalendarMapper.updateSchedule", calSch);
		return result;
	}
	
	// 홈 - 일정
	@Override
	public List<CalSch> selectListHomeCal(SqlSession sqlSession, CalSch calSch) { // 일정 목록
		List<CalSch> cList = sqlSession.selectList("CalendarMapper.selectListHomeCal", calSch);
		return cList;
	}

	@Override
	public CalSch selectOneHomeCal(SqlSession sqlSession, int schNo) { // 일정 상세
		CalSch calSch = sqlSession.selectOne("CalendarMapper.selectOneHomeCal", schNo);
		return calSch;
	}

}
