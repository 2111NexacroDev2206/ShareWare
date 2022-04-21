package org.kh.shareware.report.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Week;
import org.kh.shareware.report.store.WeekStore;
import org.springframework.stereotype.Repository;

@Repository
public class WeekStoreLogic implements WeekStore{

	//주간 업무 등록 
	@Override
	public int insertWeek(Week week, SqlSession sqlSession) {
		int result = sqlSession.insert("weekMapper.insertweek", week);
		return result;
	}

}
