package org.kh.shareware.report.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Daily;

public interface DailyStore {

	public int insertDaily(Daily daily, SqlSession sqlSession);

	public List<Daily> selectAllDaily(SqlSession sqlSession);

}
