package org.kh.shareware.approval.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;

public interface ApprovalStore {

	public int insertDoc(SqlSession sqlsession, AppDocument appDoc);

}
