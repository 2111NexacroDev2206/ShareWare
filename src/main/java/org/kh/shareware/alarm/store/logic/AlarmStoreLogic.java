package org.kh.shareware.alarm.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.alarm.domain.Alarm;
import org.kh.shareware.alarm.store.AlarmStore;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmStoreLogic implements AlarmStore{

	@Override
	public String selectOneName(SqlSession sqlSession, String memNum) { // 사원 이름 조회
		String memName = sqlSession.selectOne("AlarmMapper.selectOneMemName", memNum);
		return memName;
	}

	@Override
	public String selectOneForm(SqlSession sqlSession, int formNo) { // 양식 이름 조회
		String formName = sqlSession.selectOne("AlarmMapper.selectOneFormName", formNo);
		return formName;
	}
	
	@Override
	public int selectOneDocNo(SqlSession sqlSession, String memNum) { // 문서 번호
		int docNo = sqlSession.selectOne("AlarmMapper.selectOneDocNo", memNum);
		return docNo;
	}

	@Override
	public int insertAlarm(SqlSession sqlSession, Alarm alarm) { // 알림 등록
		int result = sqlSession.insert("AlarmMapper.insertAlarm", alarm);
		return result;
	}

}
