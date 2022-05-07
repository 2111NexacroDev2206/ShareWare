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
	public String printName(String memNum) { // 사원 이름 조회
		String memName = alStore.selectOneName(sqlSession, memNum);
		return memName;
	}

	@Override
	public String printForm(int formNo) { // 양식 이름 조회
		String formName = alStore.selectOneForm(sqlSession, formNo);
		return formName;
	}
	
	@Override
	public int printDocNo(String memNum) { // 문서 번호
		int docNo = alStore.selectOneDocNo(sqlSession, memNum);
		return docNo;
	}

	@Override
	public int registerAlarm(Alarm alarm) { // 알림 등록
		int result = alStore.insertAlarm(sqlSession, alarm);
		return result;
	}

	@Override
	public List<Alarm> printAllAlarm(String memNum) { // 알림 목록 조회
		List<Alarm> aList = alStore.selectAllAlarm(sqlSession, memNum);
		return aList;
	}

}
