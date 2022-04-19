package org.kh.shareware.approval.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.service.ApprovalService;
import org.kh.shareware.approval.store.ApprovalStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService{
	
	@Autowired
	private ApprovalStore aStore;
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int registerDoc(AppDocument appDoc) {
		int result = aStore.insertDoc(sqlsession, appDoc);
		return result;
	}

}
