package org.kh.shareware.report.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Week;
import org.kh.shareware.report.service.WeekService;
import org.kh.shareware.report.store.WeekStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekServiceImpl implements WeekService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private WeekStore wStore;
	
	@Override
	public int registerWeek(Week week) {
		int result = wStore.insertWeek(week, sqlSession);
		return result;
	}

}
