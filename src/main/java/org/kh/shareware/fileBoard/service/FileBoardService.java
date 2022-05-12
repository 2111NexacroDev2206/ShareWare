package org.kh.shareware.fileBoard.service;

import java.util.List;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.fileBoard.domain.FileBoard;

public interface FileBoardService {
	//글 등록
	int registerFileBoard(FileBoard fileBoard);

	int getListCount();
	// 글리스트
	List<FileBoard> listFileBoard(PageInfo pi);
	//조회수 증가
	void viewCountFileBoard(Integer fileBoardNo);
	//상세보기
	FileBoard detailFileBoard(Integer fileBoardNo);
	//글 삭제
	int deleteFile(Integer fileBoardNo);
	//글 수정
	int modifyFileBoard(FileBoard fileBoard);

}
