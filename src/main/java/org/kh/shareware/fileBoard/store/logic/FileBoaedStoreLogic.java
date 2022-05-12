package org.kh.shareware.fileBoard.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.fileBoard.domain.FileBoard;
import org.kh.shareware.fileBoard.store.FileBoardStore;
import org.springframework.stereotype.Repository;

@Repository
public class FileBoaedStoreLogic implements FileBoardStore{

	@Override
	public int insertFileBoard(SqlSession sqlsession, FileBoard fileBoard) {
		int result = sqlsession.insert("FileBoardMapper.insertFile", fileBoard);
		return result;
	}
	//전체 게시물의 개수
	@Override
	public int selectClistCount(SqlSession sqlsession) {
		int totalCount =sqlsession.selectOne("FileBoardMapper.selectClistCount");
		return totalCount;
	}
	@Override
	public List<FileBoard> selectListFile(SqlSession sqlsession, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<FileBoard> fList = sqlsession.selectList("FileBoardMapper.listFile", pi,rowBounds);
		return fList;
	}
	//조회수 증가
	@Override
	public void updateViewFile(SqlSession sqlsession, Integer fileBoardNo) {
		sqlsession.update("FileBoardMapper.fileViewCount",fileBoardNo);
		
	}
	//상세 페이지 보기
	@Override
	public FileBoard selectOneFile(SqlSession sqlsession, Integer fileBoardNo) {
		FileBoard fileBoard = sqlsession.selectOne("FileBoardMapper.selectOneFile",fileBoardNo);
		return fileBoard;
	}
	//글삭제
	@Override
	public int deleteFile(SqlSession sqlsession, Integer fileBoardNo) {
		int result = sqlsession.delete("FileBoardMapper.deleteFile",fileBoardNo);
		return result;
	}
	//글 수정
	@Override
	public int updateFile(SqlSession sqlsession, FileBoard fileBoard) {
		int result = sqlsession.update("FileBoardMapper.updateFile",fileBoard);
		return result;
	}
}
