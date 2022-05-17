package org.kh.shareware.project.service;

import java.util.List;

import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Important;

public interface ImportantService {
	
	public int getListCount(Integer projectNo); //페이징
	public List<Important> printAllImportant(Integer projectNo, PageInfo pi);//중요공지 목록
	public List<Important> printAllImportant(Integer projectNo);//중요공지 목록
	public Important printOneByNo(Integer importantNo); //중요공지 상세 
	public int registerImportant(Important important); //중요공지 등록
	public int modifyImportant(Important important); //중요공지 수정 
	public int removeImportant(int importantNo);	//중요공지 삭제
	public int removeFileInfo(Integer importantNo);  //첨부파일 삭제
	public int updateCount(Integer importantNo); //조회수

}
