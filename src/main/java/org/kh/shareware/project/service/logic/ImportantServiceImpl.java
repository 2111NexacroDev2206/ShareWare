package org.kh.shareware.project.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.domain.Important;
import org.kh.shareware.project.service.ImportantService;
import org.kh.shareware.project.store.ImportantStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportantServiceImpl implements ImportantService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ImportantStore iStore;
	
	//중요공지 목록
	@Override
	public List<Important> printAllImportant(Integer projectNo) {
		List<Important> iList = iStore.selectAllImportant(sqlSession, projectNo);
		return iList;
	}
	//중요공지 상세
	@Override
	public Important printOneByNo(Integer importantNo) {
		Important important = iStore.selectOneByNo(sqlSession, importantNo);
		return important;
	}
	
	//중요공지 등록 
	@Override
	public int registerImportant(Important important) {
		int result = iStore.insertImport(sqlSession, important);
		return result;
	}

}
