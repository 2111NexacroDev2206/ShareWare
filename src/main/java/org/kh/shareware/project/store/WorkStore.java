package org.kh.shareware.project.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Work;

public interface WorkStore {

	public int selectListCount(SqlSession sqlSession, Integer projectNo); //페이징
	public int insertWork(SqlSession sqlSession, Work work); // 업무현황 등록 
	public List<Work> selectAllWork(SqlSession sqlSession, Work work, PageInfo pi); // 업무현황 목록
	public List<Work> selectAllWork(SqlSession sqlSession, Integer projectNo); // 업무현황 목록
	public Work selectOneByNo(SqlSession sqlSession, Integer workNo); //업무현황 상세 
	public int updateWork(SqlSession sqlSession, Work work); //업무현황 수정
	public int deleteFileInfo(SqlSession sqlSession, Integer workNo); // 파일 삭제
	public int deleteWork(SqlSession sqlSession, Integer workNo); //업무현황 삭제 

}
