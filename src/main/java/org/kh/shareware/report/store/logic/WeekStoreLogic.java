package org.kh.shareware.report.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Week;
import org.kh.shareware.report.store.WeekStore;
import org.springframework.stereotype.Repository;

@Repository
public class WeekStoreLogic implements WeekStore{

	//주간 업무 등록 
	@Override
	public int insertWeek(Week week, SqlSession sqlSession) {
		int result = sqlSession.insert("WeekMapper.insertWeek", week);
		return result;
	}
	//주간 업무 목록
	@Override
	public List<Week> selectAllWeek(SqlSession sqlSession) {
		List<Week> wList = sqlSession.selectList("WeekMapper.selectAllWeek");
		return wList;
	}
	//주간 업무 상세
	@Override
	public Week selectOneByNo(SqlSession sqlSession, Integer wrNo) {
		Week week = sqlSession.selectOne("WeekMapper.selectOneWeek", wrNo);
		return week;
	}
	//주간 업무 삭제
	@Override
	public int deleteWeek(SqlSession sqlSession, int wrNo) {
		int result = sqlSession.delete("WeekMapper.deleteWeek", wrNo);
		return result;
	}

}
