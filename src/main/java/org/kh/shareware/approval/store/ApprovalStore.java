package org.kh.shareware.approval.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.Approval;

public interface ApprovalStore {

	public int insertDoc(SqlSession sqlsession, AppDocument appDoc); // 기안서 등록
	public int insertApp(SqlSession sqlSession, Approval app); // 결재자 등록

}
