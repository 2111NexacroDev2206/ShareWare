package org.kh.shareware.approval.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.approval.store.ApprovalStore;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalStoreLogic implements ApprovalStore{

	@Override
	public int insertDoc(SqlSession sqlSession, AppDocument appDoc) { // 기안서 등록
		int result = sqlSession.insert("ApprovalMapper.insertDoc", appDoc);
		return result;
	}

	@Override
	public int insertApp(SqlSession sqlSession, Approval app) { // 결재자 등록
		int result = sqlSession.insert("ApprovalMapper.insertApp", app);
		return result;
	}

	@Override
	public int insertRef(SqlSession sqlSession, AppReference ref) { // 참조자 등록
		int result = sqlSession.insert("ApprovalMapper.insertRef", ref);
		return result;
	}

	@Override
	public int insertFile(SqlSession sqlSession, AppFile file) { // 파일 등록
		int result = sqlSession.insert("ApprovalMapper.insertFile", file);
		return result;
	}

	@Override
	public AppForm selectForm(SqlSession sqlSession, int formNo) { // 문서 양식 조회
		AppForm form = sqlSession.selectOne("ApprovalMapper.selectOneForm", formNo);
		return form;
	}

	@Override
	public List<AppForm> selectAllForm(SqlSession sqlSession) { // 문서 양식 전체 조회
		List<AppForm> fList = sqlSession.selectList("ApprovalMapper.selectListForm");
		return fList;
	}

	@Override
	public String selectOneLeaveDoc(SqlSession sqlSession, String memberNum) { // 휴가 신청서 조회(잔여 연차)
		String leaveLeft = sqlSession.selectOne("ApprovalMapper.selectOneLeaveDoc", memberNum);
		return leaveLeft;
	}

	@Override
	public List<AppDocument> selectAllDoc(SqlSession sqlSession, AppDocument appDoc, PageInfo pi) { // 기안 문서 조회(기안 문서함)
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<AppDocument> dList = sqlSession.selectList("ApprovalMapper.selectListDoc", appDoc, rowBounds);
		return dList;
	}

	@Override
	public int selectListCount(SqlSession sqlSession, AppDocument appDoc) { // 문서함 페이징
		int totalCount = sqlSession.selectOne("ApprovalMapper.selectOneListCount", appDoc);
		return totalCount;
	}

	@Override
	public List<AppDocument> selectAllDraftSearch(SqlSession sqlSession, Search search, PageInfo pi) { // 기안 문서함 검색
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<AppDocument> dList = sqlSession.selectList("ApprovalMapper.selectListDraftSearch", search, rowBounds);
		return dList;
	}

	@Override
	public int selectSearchDraftCount(SqlSession sqlSession, Search search) { // 기안 문서함 검색 페이징
		int totalCount = sqlSession.selectOne("ApprovalMapper.selectOneSearchDraftCount", search);
		return totalCount;
	}

	@Override
	public AppDocument selectOneDoc(SqlSession sqlSession, int docNo) { // 기안 문서함 상세 조회
		AppDocument appDoc = sqlSession.selectOne("ApprovalMapper.selectOneDoc", docNo);
		return appDoc;
	}

	@Override
	public List<Approval> selectAllApp(SqlSession sqlSession, int docNo) { // 기안 문서함 상세 조회(결재자)
		List<Approval> aList = sqlSession.selectList("ApprovalMapper.selectListApp", docNo);
		return aList;
	}

	@Override
	public List<AppReference> selectAllRef(SqlSession sqlSession, int docNo) { // 기안 문서함 상세 조회(참조자)
		List<AppReference> rList = sqlSession.selectList("ApprovalMapper.selectListRef", docNo);
		return rList;
	}

	@Override
	public int deleteDoc(SqlSession sqlSession, int docNo) { // 상신 취소
		int result = sqlSession.delete("ApprovalMapper.deleteDoc", docNo);
		return result;
	}

	@Override
	public AppFile selectOneFile(SqlSession sqlSession, int docNo) { // 기안 문서함 상세 조회(파일)
		AppFile appFile = sqlSession.selectOne("ApprovalMapper.selectOneFile", docNo);
		return appFile;
	}

}