package org.kh.shareware.project.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.domain.Important;

public interface ImportantStore {

	public List<Important> selectAllImportant(SqlSession sqlSession, Integer projectNo); //중요공지 목록
	public Important selectOneByNo(SqlSession sqlSession, Integer importantNo); //중요공지 상세
	public int insertImport(SqlSession sqlSession, Important important); //중요공지 등록

}
