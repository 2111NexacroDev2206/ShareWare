package org.kh.shareware.project.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Work;
import org.kh.shareware.project.store.WorkStore;
import org.springframework.stereotype.Repository;

@Repository
public class WorkStoreLogic implements WorkStore{

	//업무현황 등록
	@Override
	public int insertWork(SqlSession sqlSession, Work work) {
		int result = sqlSession.insert("WorkMapper.insertWork", work);
		return result;
	}
	//페이징
	@Override
	public int selectListCount(SqlSession sqlSession, Integer projectNo) {
		int totalCount = sqlSession.selectOne("WorkMapper.selectListCount", projectNo);
		return totalCount;
	}
	//업무현황 목록
	@Override
	public List<Work> selectAllWork(SqlSession sqlSession, Work work, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Work> wList = sqlSession.selectList("WorkMapper.selectAllWork", work, rowBounds);
		return wList;
	}
	//업무현황 목록
	@Override
	public List<Work> selectAllWork(SqlSession sqlSession, Integer projectNo) {
		List<Work> wList = sqlSession.selectList("WorkMapper.selectWork", projectNo);
		return wList;
	}
	//업무현황 상세 
	@Override
	public Work selectOneByNo(SqlSession sqlSession, Integer workNo) {
		Work work = sqlSession.selectOne("WorkMapper.selectOneWork", workNo); 
		return work;
	}
	//업무현황 수정
	@Override
	public int updateWork(SqlSession sqlSession, Work work) {
		int result = sqlSession.update("WorkMapper.updateWork", work);
		return result;
	}
	//파일 삭제 
	@Override
	public int deleteFileInfo(SqlSession sqlSession, Integer workNo) {
		int result = sqlSession.delete("WorkMapper.deleteFileInfo", workNo);
		return result;
	}
	//업무현황 삭제 
	@Override
	public int deleteWork(SqlSession sqlSession, Integer workNo) {
		int result = sqlSession.delete("WorkMapper.deleteWork", workNo); 
		return result;
	}
	
	
}
