package org.kh.shareware.project.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
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
	
	//페이징
	@Override
	public int getListCount(Integer projectNo) {
		int totalCount = iStore.selectListCount(sqlSession, projectNo);
		return totalCount;
	}
	//중요공지 목록
	@Override
	public List<Important> printAllImportant(Integer projectNo , PageInfo pi) {
		List<Important> iList = iStore.selectAllImportant(sqlSession, projectNo, pi);
		return iList;
	}
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
	//중요공지 수정 
	@Override
	public int modifyImportant(Important important) {
		int result = iStore.updateImportant(sqlSession, important);
		return result;
	}
	//중요공지 삭제
	@Override
	public int removeImportant(int importantNo) {
		int result = iStore.deleteImportant(sqlSession, importantNo);
		return result;
	}
	//첨부파일 삭제
	@Override
	public int removeFileInfo(Integer importantNo) {
		int result = iStore.deleteFileInfo(sqlSession, importantNo);
		return result;
	}
	//조회수
	@Override
	public int updateCount(Integer importantNo) {
		int result = iStore.updateCount(sqlSession, importantNo);
		return result;
	}
	

}
