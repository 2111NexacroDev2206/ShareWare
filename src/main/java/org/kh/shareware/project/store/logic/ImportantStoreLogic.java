package org.kh.shareware.project.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Important;
import org.kh.shareware.project.store.ImportantStore;
import org.springframework.stereotype.Repository;

@Repository
public class ImportantStoreLogic implements ImportantStore {

	//페이징
	@Override
	public int selectListCount(SqlSession sqlSession, Integer projectNo) {
		int totalCount = sqlSession.selectOne("ImportantMapper.selectListCount", projectNo);
		return totalCount;
	}
	//중요공지 목록
	@Override
	public List<Important> selectAllImportant(SqlSession sqlSession, Integer projectNo, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Important> iList = sqlSession.selectList("ImportantMapper.selectAllImportant", projectNo, rowBounds);
		return iList;
	}
	//중요공지 목록
	@Override
	public List<Important> selectAllImportant(SqlSession sqlSession, Integer projectNo) {
		List<Important> iList = sqlSession.selectList("ImportantMapper.selectImportant", projectNo);
		return iList;
	}
	//중요공지 상세 
	@Override
	public Important selectOneByNo(SqlSession sqlSession, Integer importantNo) {
		Important important = sqlSession.selectOne("ImportantMapper.selectOneImportant", importantNo);
		return important;
	}
	
	//중요공지 등록
	@Override
	public int insertImport(SqlSession sqlSession, Important important) {
		int result = sqlSession.insert("ImportantMapper.insertImportant", important );
		return result;
	}
	
	//중요공지 수정
	@Override
	public int updateImportant(SqlSession sqlSession, Important important) {
		int result = sqlSession.update("ImportantMapper.updateImportant", important);
		return result;
	}
	//중요공지 삭제 
	@Override
	public int deleteImportant(SqlSession sqlSession, int importantNo) {
		int result = sqlSession.delete("ImportantMapper.deleteImportant", importantNo);
		return result;
	}
	//첨부파일 삭제
	@Override
	public int deleteFileInfo(SqlSession sqlSession, Integer importantNo) {
		int result = sqlSession.delete("ImportantMapper.deleteFileInfo" , importantNo);
		return result;
	}

	//조회수
	@Override
	public int updateCount(SqlSession sqlSession, Integer importantNo) {
		int result = sqlSession.update("ImportantMapper.updateCount", importantNo);
		return result;
	}


	
}
