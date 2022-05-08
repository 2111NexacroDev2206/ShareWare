package org.kh.shareware.alarm.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.alarm.domain.Alarm;
import org.kh.shareware.alarm.service.AlarmService;
import org.kh.shareware.alarm.store.AlarmStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImpl implements AlarmService{
	
	@Autowired
	private AlarmStore alStore;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Alarm> printAllAlarm(String memNum) { // 알림 목록 조회
		List<Alarm> aList = alStore.selectAllAlarm(sqlSession, memNum);
		return aList;
	}
	
	@Override
	public int modifyAlarm(int alarmNo) { // 알림 읽음 처리
		int result = alStore.updateAlarm(sqlSession, alarmNo);
		return result;
	}
	
	@Override
	public int modifyAllAlarm(String memNum) { // 알림 모두 읽음 처리
		int result = alStore.updateAllAlarm(sqlSession, memNum);
		return result;
	}
	
	@Override
	public int getListCount(String memNum) { // 알림 카운트
		int count = alStore.selectOneList(sqlSession, memNum);
		return count;
	}
	
	// 전자결재
	@Override
	public int printDocNo(String memNum) { // 문서 번호
		int docNo = alStore.selectOneDocNo(sqlSession, memNum);
		return docNo;
	}
	
	@Override
	public String printName(int docNo) { // 기안자 이름 조회
		String memName = alStore.selectOneName(sqlSession, docNo);
		return memName;
	}

	@Override
	public String printForm(int docNo) { // 양식 이름 조회
		String formName = alStore.selectOneForm(sqlSession, docNo);
		return formName;
	}

	@Override
	public int registerAlarm(Alarm alarm) { // 알림 등록
		int result = alStore.insertAlarm(sqlSession, alarm);
		return result;
	}

	@Override
	public String printNum(int docNo) { // 기안자 사원번호 조회
		String memNum = alStore.selectOneNum(sqlSession, docNo);
		return memNum;
	}

	@Override
	public String printAppName(String appMemNum) { // 반려자 이름 조회
		String appName = alStore.selectOneAppName(sqlSession, appMemNum);
		return appName;
	}

}
