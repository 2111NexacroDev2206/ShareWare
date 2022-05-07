package org.kh.shareware.alarm.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.alarm.domain.Alarm;

public interface AlarmStore {

	String selectOneName(SqlSession sqlSession, String memNum); // 사원 이름 조회
	String selectOneForm(SqlSession sqlSession, int formNo); // 양식 이름 조회
	int selectOneDocNo(SqlSession sqlSession, String memNum); // 문서 번호
	int insertAlarm(SqlSession sqlSession, Alarm alarm); // 알림 등록

}
