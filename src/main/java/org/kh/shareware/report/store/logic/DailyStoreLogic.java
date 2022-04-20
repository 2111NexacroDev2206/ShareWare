package org.kh.shareware.report.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Daily;
import org.kh.shareware.report.store.DailyStore;
import org.springframework.stereotype.Repository;

@Repository
public class DailyStoreLogic implements DailyStore{

	//일일 업무 등록
	@Override
	public int insertDaily(Daily daily, SqlSession sqlSession) {
		int result = sqlSession.insert("DailyMapper.insertDaily", daily);
		return result;
	}

	@Override
	public List<Daily> selectAllDaily(SqlSession sqlSession) {
		List<Daily> dList = sqlSession.selectList("DailyMapper.selectAllDaily");
		return dList;
	}
	
}
