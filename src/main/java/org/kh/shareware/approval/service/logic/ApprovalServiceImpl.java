package org.kh.shareware.approval.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.approval.service.ApprovalService;
import org.kh.shareware.approval.store.ApprovalStore;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService{
	
	@Autowired
	private ApprovalStore aStore;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registerDoc(AppDocument appDoc) { // 기안서 등록
		int result = aStore.insertDoc(sqlSession, appDoc);
		return result;
	}

	@Override
	public int registerApp(Approval app) { // 결재자 등록
		int result = aStore.insertApp(sqlSession, app);
		return result;
	}

	@Override
	public int registerRef(AppReference ref) { // 참조자 등록
		int result = aStore.insertRef(sqlSession, ref);
		return result;
	}

	@Override
	public int registerFile(AppFile file) { // 파일 등록
		int result = aStore.insertFile(sqlSession, file);
		return result;
	}

	@Override
	public AppForm printForm(int formNo) { // 문서 양식 조회
		AppForm form = aStore.selectForm(sqlSession, formNo);
		return form;
	}

	@Override
	public List<AppForm> printAllForm() { // 문서 양식 전체 조회
		List<AppForm> fList = aStore.selectAllForm(sqlSession);
		return fList;
	}

	@Override
	public String printOneLeaveDoc(String memberNum) { // 휴가 신청서 조회(잔여 연차)
		String leaveLeft = aStore.selectOneLeaveDoc(sqlSession, memberNum);
		return leaveLeft;
	}

	@Override
	public List<AppDocument> printAll(AppDocument appDoc, PageInfo pi) { // 기안 문서 조회(기안 문서함)
		List<AppDocument> dList = aStore.selectAllDoc(sqlSession, appDoc, pi);
		return dList;
	}

	@Override
	public int getListCount(AppDocument appDoc) { // 문서함 페이징
		int totalCount = aStore.selectListCount(sqlSession, appDoc);
		return totalCount;
	}

	@Override
	public List<AppDocument> printSearchDraft(Search search, PageInfo pi) { // 기안 문서함 검색
		List<AppDocument> dList = aStore.selectAllDraftSearch(sqlSession, search, pi);
		return dList;
	}

	@Override
	public int getSearchDraftCount(Search search) { // 기안 문서함 검색 페이징
		int totalCount = aStore.selectSearchDraftCount(sqlSession, search);
		return totalCount;
	}

	@Override
	public AppDocument printOneDoc(int docNo) { // 기안 문서함 상세 조회
		AppDocument appDoc = aStore.selectOneDoc(sqlSession, docNo);
		return appDoc;
	}

	@Override
	public List<Approval> printAllApp(int docNo) { // 기안 문서함 상세 조회(결재자)
		List<Approval> aList = aStore.selectAllApp(sqlSession, docNo);
		return aList;
	}

	@Override
	public List<AppReference> printAllRef(int docNo) { // 기안 문서함 상세 조회(참조자)
		List<AppReference> rList = aStore.selectAllRef(sqlSession, docNo);
		return rList;
	}

	@Override
	public int removeDoc(int docNo) { // 상신 취소
		int result = aStore.deleteDoc(sqlSession, docNo);
		return result;
	}

	@Override
	public AppFile printOneFile(int docNo) { // 기안 문서함 상세 조회(파일)
		AppFile appFile = aStore.selectOneFile(sqlSession, docNo);
		return appFile;
	}

}
