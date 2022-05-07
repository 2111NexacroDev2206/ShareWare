package org.kh.shareware.alarm.service;

import java.util.List;

import org.kh.shareware.alarm.domain.Alarm;

public interface AlarmService {

	public String printName(String memNum); // 사원 이름 조회
	public String printForm(int formNo); // 양식 이름 조회
	public int printDocNo(String memNum); // 문서 번호
	public int registerAlarm(Alarm alarm); // 알림 등록
	public List<Alarm> printAllAlarm(String memNum); // 알림 목록 조회

}
