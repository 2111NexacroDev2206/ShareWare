package org.kh.shareware.approval.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;

public interface ApprovalStore {

	public int insertDoc(SqlSession sqlsession, AppDocument appDoc); // 기안서 등록
	public int insertApp(SqlSession sqlSession, Approval app); // 결재자 등록
	public int insertRef(SqlSession sqlSession, AppReference ref); // 참조자 등록
	public int insertFile(SqlSession sqlSession, AppFile file); // 파일 등록
	public AppForm selectForm(SqlSession sqlSession, int formNo); // 문서 양식 조회
	public List<AppForm> selectAllForm(SqlSession sqlSession); // 문서 양식 전체 조회
	public String selectOneLeaveDoc(SqlSession sqlSession, String memberNum); // 휴가 신청서 조회(잔여 연차)
	public List<AppDocument> selectAllDoc(SqlSession sqlSession, AppDocument appDoc, PageInfo pi); // 기안 문서 조회(기안 문서함)
	public int selectListCount(SqlSession sqlSession, AppDocument appDoc); // 문서함 페이징
	public List<AppDocument> selectAllDraftSearch(SqlSession sqlSession, Search search, PageInfo pi); // 기안 문서함 검색
	public int selectSearchDraftCount(SqlSession sqlSession, Search search); // 기안 문서함 검색 페이징

}
