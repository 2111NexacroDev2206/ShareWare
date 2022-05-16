package org.kh.shareware.alarm.service;

import java.util.List;

import org.kh.shareware.alarm.domain.Alarm;

public interface AlarmService {
	public List<Alarm> printAllAlarm(String memNum); // 알림 목록 조회
	public int modifyAlarm(int alarmNo); // 알림 읽음 처리
	public int modifyAllAlarm(String memNum); // 알림 모두 읽음 처리
	public int getListCount(String memNum); // 알림 카운트
	public int registerAlarm(Alarm alarm); // 알림 등록
	// 전자결재
	public int printDocNo(String memNum); // 문서 번호
	public String printName(int docNo); // 기안자 이름 조회
	public String printForm(int docNo); // 양식 이름 조회
	public String printNum(int docNo); // 기안자 사원번호 조회
	public String printAppName(String appMemNum); // 반려자 이름 조회

}
