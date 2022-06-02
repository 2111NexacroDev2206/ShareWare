package org.kh.shareware.project.service;

import java.util.List;

import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Work;

public interface WorkService {

	public int getListCount(Integer projectNo); //페이징
	public List<Work> printAllWork(Work work, PageInfo pi); // 업무현황 목록
	public List<Work> printAllWork(Integer projectNo); // 업무현황 목록
	public int registerWork(Work work); // 업무현황 등록
	public Work printOneByNo(Integer workNo); //업무현황 상세 
	public int modifyWork(Work work); //업무현황 수정
	public int removeFileInfo(Integer workNo); //파일 삭제 
	public int removeWork(Integer workNo); // 업무현황 삭제 
	

	

}
