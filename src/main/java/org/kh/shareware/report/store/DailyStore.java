package org.kh.shareware.report.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.report.domain.Daily;

public interface DailyStore {

	public int selectListCount(SqlSession sqlSession, String memNum); //페이징
	public int insertDaily(Daily daily, SqlSession sqlSession); // 일일업무 등록
	public List<Daily> selectAllDaily(SqlSession sqlSession, String memNum, PageInfo pi);  // 일일 업무 목록
	public Daily selectOneByNo(SqlSession sqlSession, int drNo);  //일일업무 상세 
	public int deleteDaily(SqlSession sqlSession, int drNo);	// 일일업무 삭제 
	public int updateDaily(SqlSession sqlSession, Daily daily); // 일일업무 수정
	public int deleteFileInfo(SqlSession sqlSession, Integer drNo); //파일 삭제

}
