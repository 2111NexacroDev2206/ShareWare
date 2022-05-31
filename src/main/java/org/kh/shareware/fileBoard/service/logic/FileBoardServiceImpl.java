package org.kh.shareware.fileBoard.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.fileBoard.domain.FileBoard;
import org.kh.shareware.fileBoard.service.FileBoardService;
import org.kh.shareware.fileBoard.store.FileBoardStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileBoardServiceImpl implements FileBoardService{
	@Autowired
	private FileBoardStore fStore;
	@Autowired
	private SqlSession sqlsession;
	
	
	@Override
	public int registerFileBoard(FileBoard fileBoard) {
		int result = fStore.insertFileBoard(sqlsession, fileBoard);
		return result;
	}
	// 글갯수
	@Override
	public int getListCount() {
		int result = fStore.selectClistCount(sqlsession);
		return result;
	}
	//글리스트
	@Override
	public List<FileBoard> listFileBoard(PageInfo pi) {
		List<FileBoard> fList= fStore.selectListFile(sqlsession, pi);
		return fList;
	}
	//조회수
	@Override
	public void viewCountFileBoard(Integer fileBoardNo) {
		fStore.updateViewFile(sqlsession, fileBoardNo);
		
	}
	//상세보기
	@Override
	public FileBoard detailFileBoard(Integer fileBoardNo) {
		FileBoard fileBoard = fStore.selectOneFile(sqlsession, fileBoardNo);
		return fileBoard;
	}
	// 글삭제
	@Override
	public int removeFileBoard(Integer fileBoardNo) {
		int result = fStore.deleteFile(sqlsession,fileBoardNo);
		return result;
	}
	//글 수정
	@Override
	public int modifyFileBoard(FileBoard fileBoard) {
		int result = fStore.updateFile(sqlsession,fileBoard);
		return result;
	}

}
