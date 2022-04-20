package org.kh.shareware.approval.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.approval.store.ApprovalStore;
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

}