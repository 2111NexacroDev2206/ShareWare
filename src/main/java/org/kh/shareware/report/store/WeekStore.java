package org.kh.shareware.report.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Week;

public interface WeekStore {

	public int insertWeek(Week week, SqlSession sqlSession);

}
