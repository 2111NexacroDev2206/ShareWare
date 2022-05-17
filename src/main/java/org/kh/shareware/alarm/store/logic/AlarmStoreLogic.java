package org.kh.shareware.alarm.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.alarm.domain.Alarm;
import org.kh.shareware.alarm.store.AlarmStore;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmStoreLogic implements AlarmStore {
	
	@Override
	public List<Alarm> selectAllAlarm(SqlSession sqlSession, String memNum) { // 알림 목록 조회
		List<Alarm> aList = sqlSession.selectList("AlarmMapper.selectListAlarm", memNum);
		return aList;
	}
	
	@Override
	public int updateAlarm(SqlSession sqlSession, int alarmNo) { // 알림 읽음 처리
		int result = sqlSession.update("AlarmMapper.updateAlarm", alarmNo);
		return result;
	}
	
	@Override
	public int updateAllAlarm(SqlSession sqlSession, String memNum) { // 알림 모두 읽음 처리
		int result = sqlSession.update("AlarmMapper.updateAllAlarm", memNum);
		return result;
	}
	
	@Override
	public int selectOneList(SqlSession sqlSession, String memNum) { // 알림 카운트
		int count = sqlSession.selectOne("AlarmMapper.selectOneCount", memNum);
		return count;
	}
	
	@Override
	public int insertAlarm(SqlSession sqlSession, Alarm alarm) { // 알림 등록
		int result = sqlSession.insert("AlarmMapper.insertAlarm", alarm);
		return result;
	}
	
	// 전자결재
	@Override
	public int selectOneDocNo(SqlSession sqlSession, String memNum) { // 문서 번호
		int docNo = sqlSession.selectOne("AlarmMapper.selectOneDocNo", memNum);
		return docNo;
	}

	@Override
	public String selectOneName(SqlSession sqlSession, int docNo) { // 기안자 이름 조회
		String memName = sqlSession.selectOne("AlarmMapper.selectOneMemName", docNo);
		return memName;
	}

	@Override
	public String selectOneForm(SqlSession sqlSession, int docNo) { // 양식 이름 조회
		String formName = sqlSession.selectOne("AlarmMapper.selectOneFormName", docNo);
		return formName;
	}

	@Override
	public String selectOneNum(SqlSession sqlSession, int docNo) { // 기안자 사원번호 조회
		String memNum = sqlSession.selectOne("AlarmMapper.selectOneNum", docNo);
		return memNum;
	}

	@Override
	public String selectOneAppName(SqlSession sqlSession, String appMemNum) { // 반려자 이름 조회
		String appName = sqlSession.selectOne("AlarmMapper.selectOneAppName", appMemNum);
		return appName;
	}

}
