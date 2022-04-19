package org.kh.shareware.approval.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.store.ApprovalStore;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalStoreLogic implements ApprovalStore{

	@Override
	public int insertDoc(SqlSession sqlsession, AppDocument appDoc) {
		int result = sqlsession.insert("ApprovalMapper.insertDoc", appDoc);
		return result;
	}

}