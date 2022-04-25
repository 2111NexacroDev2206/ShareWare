package org.kh.shareware.approval.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
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
	public int registerRef(AppReference ref) {
		int result = aStore.insertRef(sqlSession, ref);
		return result;
	}

	@Override
	public int registerFile(AppFile file) {
		int result = aStore.insertFile(sqlSession, file);
		return result;
	}

}
