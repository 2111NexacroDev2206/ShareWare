package org.kh.shareware.project.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Important;

public interface ImportantStore {

	public int selectListCount(SqlSession sqlSession, Integer projectNo);	//페이징
	public List<Important> selectAllImportant(SqlSession sqlSession, Integer projectNo, PageInfo pi); //중요공지 목록
	public Important selectOneByNo(SqlSession sqlSession, Integer importantNo); //중요공지 상세
	public int insertImport(SqlSession sqlSession, Important important); //중요공지 등록
	public int updateImportant(SqlSession sqlSession, Important important); //중요공지 수정 
	public int deleteImportant(SqlSession sqlSession, int importantNo);		//중요공지 삭제
	public int deleteFileInfo(SqlSession sqlSession, Integer importantNo); //첨부파일 삭제
	public int updateCount(SqlSession sqlSession, Integer importantNo); //조회수

}
