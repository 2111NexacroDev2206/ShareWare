package org.kh.shareware.report.service;

import java.util.List;

import org.kh.shareware.report.domain.Week;

public interface WeekService {

	public int registerWeek(Week week); // 주간업무 등록
	public List<Week> printAllWeek(); // 주간업무 목록
	public Week printOneByNo(Integer wrNo); //주간업무 상세
	public int removeWeek(int wrNo);	//주간업무 삭제

}
