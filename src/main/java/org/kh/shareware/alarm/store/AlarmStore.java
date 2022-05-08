package org.kh.shareware.alarm.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.alarm.domain.Alarm;

public interface AlarmStore {
	public List<Alarm> selectAllAlarm(SqlSession sqlSession, String memNum); // 알림 목록 조회
	public int updateAlarm(SqlSession sqlSession, int alarmNo); // 알림 읽음 처리
	public int updateAllAlarm(SqlSession sqlSession, String memNum); // 알림 모두 읽음 처리
	public int selectOneList(SqlSession sqlSession, String memNum); // 알림 카운트
	public int insertAlarm(SqlSession sqlSession, Alarm alarm); // 알림 등록
	// 전자결재
	public int selectOneDocNo(SqlSession sqlSession, String memNum); // 문서 번호
	public String selectOneName(SqlSession sqlSession, int docNo); // 기안자 이름 조회
	public String selectOneForm(SqlSession sqlSession, int docNo); // 양식 이름 조회
	public String selectOneNum(SqlSession sqlSession, int docNo); // 기안자 사원번호 조회
	public String selectOneAppName(SqlSession sqlSession, String appMemNum); // 반려자 이름 조회

}
