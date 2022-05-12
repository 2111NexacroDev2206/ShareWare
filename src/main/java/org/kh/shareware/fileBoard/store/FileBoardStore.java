package org.kh.shareware.fileBoard.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.fileBoard.domain.FileBoard;

public interface FileBoardStore  {
	//글 등록
	int insertFileBoard(SqlSession sqlsession, FileBoard fileBoard);
	//글 개수
	int selectClistCount(SqlSession sqlsession);
	//글리스트
	List<FileBoard> selectListFile(SqlSession sqlsession, PageInfo pi);
	//조회수 증가
	void updateViewFile(SqlSession sqlsession, Integer fileBoardNo);
	//상세 페이지 보기
	FileBoard selectOneFile(SqlSession sqlsession, Integer fileBoardNo);
	//글 삭제
	int deleteFile(SqlSession sqlsession, Integer fileBoardNo);
	//글 수정
	int updateFile(SqlSession sqlsession, FileBoard fileBoard);

}
