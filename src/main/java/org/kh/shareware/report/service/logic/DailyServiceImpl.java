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
	//일일 업무 목록
	@Override
	public List<Daily> printAllDaily() {
		List<Daily> dList = dStore.selectAllDaily(sqlSession);
		return dList;
	}
	//일일 업무 상세
	@Override
	public Daily printOneByNo(int drNo) {
		Daily daily = dStore.selectOneByNo(sqlSession, drNo);
		return daily;
	}
	//일일 업무 삭제
	@Override
	public int removeDaily(int drNo) {
		int result = dStore.deleteDaily(sqlSession, drNo);
		return result;
	}
	//일일 업무 수정 페이지
	@Override
	public int modifyDaily(Daily daily) {
		int result = dStore.updateDaily(sqlSession, daily);
		return result;
	}

}