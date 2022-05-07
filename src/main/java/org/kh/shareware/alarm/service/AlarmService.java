package org.kh.shareware.alarm.service;

import org.kh.shareware.alarm.domain.Alarm;

public interface AlarmService {

	String printName(String memNum); // 사원 이름 조회
	String printForm(int formNo); // 양식 이름 조회
	int printDocNo(String memNum); // 문서 번호
	int registerAlarm(Alarm alarm); // 알림 등록

}
