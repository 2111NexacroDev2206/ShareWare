package org.kh.shareware.approval.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;

public interface ApprovalStore {

	public int insertDoc(SqlSession sqlsession, AppDocument appDoc); // 기안서 등록
	public int insertApp(SqlSession sqlSession, Approval app); // 결재자 등록
	public int insertRef(SqlSession sqlSession, AppReference ref); // 참조자 등록
	public int insertFile(SqlSession sqlSession, AppFile file); // 파일 등록
	public AppForm selectForm(SqlSession sqlSession, String parameter); // 문서 양식 조회

}
