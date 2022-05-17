package org.kh.shareware.project.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Work;
import org.kh.shareware.project.service.WorkService;
import org.kh.shareware.project.store.WorkStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkSerivceImpl implements WorkService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private WorkStore wStore;
	
	//업무현황 등록
	@Override
	public int registerWork(Work work) {
		int result = wStore.insertWork(sqlSession, work);
		return result;
	}
	//페이징
	@Override
	public int getListCount(Integer projectNo) {
		int totalCount = wStore.selectListCount(sqlSession, projectNo);
		return totalCount;
	}
	//업무현황 목록
	@Override
	public List<Work> printAllWork(Work work, PageInfo pi) {
		List<Work> wList = wStore.selectAllWork(sqlSession, work, pi);
		return wList;
	}
	//업무현황 목록
		@Override
		public List<Work> printAllWork(Integer projectNo) {
			List<Work> wList = wStore.selectAllWork(sqlSession, projectNo);
			return wList;
		}

	//업무현황 상세
	@Override
	public Work printOneByNo(Integer workNo) {
		Work work = wStore.selectOneByNo(sqlSession, workNo);
		return work;
	}
	//업무현황 수정
	@Override
	public int modifyWork(Work work) {
		int result = wStore.updateWork(sqlSession, work);
		return result;
	}
	//파일 삭제
	@Override
	public int removeFileInfo(Integer workNo) {
		int result = wStore.deleteFileInfo(sqlSession, workNo);
		return result;
	}
	//업무현황 삭제 
	@Override
	public int removeWork(Integer workNo) {
		int result = wStore.deleteWork(sqlSession, workNo);
		return result;
	}
	
}
