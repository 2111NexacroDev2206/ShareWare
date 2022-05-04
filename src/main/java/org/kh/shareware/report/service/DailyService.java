package org.kh.shareware.report.service;

import java.util.List;

import org.kh.shareware.report.domain.Daily;

public interface DailyService {
	public int registerDaily(Daily daily);  // 일일 업무 등록
	public List<Daily> printAllDaily(String memNum);  	//일일 업무 목록
	public Daily printOneByNo(int drNo);	//일일 업무 상세	
	public int removeDaily(int drNo);		//일일 업무 삭제 
	public int modifyDaily(Daily daily); 	// 일일 업무 수정
	public int removeFileInfo(Integer drNo);  //파일 삭제 

}
