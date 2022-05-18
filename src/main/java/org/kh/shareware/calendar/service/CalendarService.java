
package org.kh.shareware.calendar.service;

import java.util.List;

import org.kh.shareware.calendar.domain.CalSch;

public interface CalendarService {

	

	public int registerSchedule(CalSch calSch);

	public List<CalSch> printAllSchedule(CalSch calSch);

	public CalSch printOneSchedule(int schNo);
	
	public int modifySchedule(CalSch calSch);
	
	// 홈 - 일정
	public List<CalSch> printAllHomeCal(CalSch calSch); // 일정 목록

	public CalSch printOneHomeCal(int schNo); // 일정 상세
 
}
