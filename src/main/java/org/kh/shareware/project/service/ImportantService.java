package org.kh.shareware.project.service;

import java.util.List;

import org.kh.shareware.project.domain.Important;

public interface ImportantService {

	public List<Important> printAllImportant(Integer projectNo);//중요공지 목록
	public Important printOneByNo(Integer importantNo); //중요공지 상세 
	public int registerImportant(Important important); //중요공지 등록

}
