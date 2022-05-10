package org.kh.shareware.report.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
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
	//페이징
	@Override
	public int selectListCount(SqlSession sqlSession, String memNum) {
		int totalCount = sqlSession.selectOne("WeekMapper.selectListCount", memNum);
		return totalCount;
	}
	//주간 업무 목록
	@Override
	public List<Week> selectAllWeek(SqlSession sqlSession, String memNum, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Week> wList = sqlSession.selectList("WeekMapper.selectAllWeek" , memNum, rowBounds);
		return wList;
	}
	//주간 업무 상세
	@Override
	public Week selectOneByNo(SqlSession sqlSession, Integer wrNo) {
		Week week = sqlSession.selectOne("WeekMapper.selectOneWeek", wrNo);
		return week;
	}
	//주간 업무 수정
	@Override
	public int updateWeek(SqlSession sqlSession, Week week) {
		int result = sqlSession.update("WeekMapper.updateWeek", week);
		return result;
	}
	//주간 업무 삭제
	@Override
	public int deleteWeek(SqlSession sqlSession, int wrNo) {
		int result = sqlSession.delete("WeekMapper.deleteWeek", wrNo);
		return result;
	}
	@Override
	public int deleteFileInfo(SqlSession sqlSession, Integer wrNo) {
		int result = sqlSession.update("WeekMapper.updateFileInfo" , wrNo);
		return result;
	}

}
