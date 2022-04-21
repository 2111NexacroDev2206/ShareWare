package org.kh.shareware.report.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.report.domain.Daily;
import org.kh.shareware.report.service.DailyService;
import org.kh.shareware.report.store.DailyStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyServiceImpl implements DailyService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DailyStore dStore;

	//일일 업무 등록 
	public int registerDaily(Daily daily) {
		int result = dStore.insertDaily(daily, sqlSession);
		return result;
	}

	@Override
	public List<Daily> printAllDaily() {
		List<Daily> dList = dStore.selectAllDaily(sqlSession);
		return dList;
	}
}