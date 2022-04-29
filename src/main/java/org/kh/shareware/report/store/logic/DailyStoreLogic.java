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
	//일일 업무 목록
	@Override
	public List<Daily> selectAllDaily(SqlSession sqlSession, String memNum) {
		List<Daily> dList = sqlSession.selectList("DailyMapper.selectAllDaily", memNum);
		return dList;
	}
	//일일 업무 상세 
	@Override
	public Daily selectOneByNo(SqlSession sqlSession, int drNo) {
		Daily daily = sqlSession.selectOne("DailyMapper.selectOneDaily",drNo );
		return daily;
	}
	//일일 업무 삭제
	@Override
	public int deleteDaily(SqlSession sqlSession, int drNo) {
		int result = sqlSession.delete("DailyMapper.deleteDaily", drNo);
		return result;
	}
	//일일 업무 수정
	@Override
	public int updateDaily(SqlSession sqlSession, Daily daily) {
		int result = sqlSession.update("DailyMapper.updateDaily", daily);
		return result;
	}
	//파일삭제
	@Override
	public int deleteFileInfo(SqlSession sqlSession, Integer drNo) {
		int result = sqlSession.update("DailyMapper.updateFileInfo", drNo);
		return result;
	}
	
	
}
