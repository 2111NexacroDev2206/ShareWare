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

}
