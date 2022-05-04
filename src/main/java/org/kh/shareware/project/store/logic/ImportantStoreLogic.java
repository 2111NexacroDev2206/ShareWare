package org.kh.shareware.project.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.domain.Important;
import org.kh.shareware.project.store.ImportantStore;
import org.springframework.stereotype.Repository;

@Repository
public class ImportantStoreLogic implements ImportantStore {

	//중요공지 목록
	@Override
	public List<Important> selectAllImportant(SqlSession sqlSession, Integer projectNo) {
		List<Important> iList = sqlSession.selectList("ImportantMapper.selectAllImportant", projectNo);
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

	
}
