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
	public List<AppDocument> selectAllDoc(SqlSession sqlSession, AppDocument appDoc, PageInfo pi); // 문서 조회(기안 문서함/임시 저장함)
	public int selectListCount(SqlSession sqlSession, AppDocument appDoc); // 문서함 페이징
	public List<AppDocument> selectAllDraftSearch(SqlSession sqlSession, Search search, PageInfo pi); // 문서함 검색
	public int selectSearchDraftCount(SqlSession sqlSession, Search search); // 문서함 검색 페이징
	public AppDocument selectOneDoc(SqlSession sqlSession, int docNo); // 문서함 상세 조회
	public List<Approval> selectAllApp(SqlSession sqlSession, int docNo); // 문서함 상세 조회(결재자)
	public List<AppReference> selectAllRef(SqlSession sqlSession, int docNo); // 문서함 상세 조회(참조자)
	public int deleteDoc(SqlSession sqlSession, int docNo); // 상신 취소
	public AppFile selectOneFile(SqlSession sqlSession, int docNo); // 문서함 상세 조회(파일)
	public int updateDoc(SqlSession sqlSession, AppDocument appDoc); // 임시 저장 수정(문서)
	public int deleteApp(SqlSession sqlSession, int docNo); // 결재자 삭제
	public int deleteRef(SqlSession sqlSession, int docNo); // 참조자 삭제
	public int updateApp(SqlSession sqlSession, Approval app); // 결재자 상태 변경(임시->대기)
	public int updateRef(SqlSession sqlSession, AppReference ref); // 참조자 상태 변경(임시->참조)
	public int deleteFile(SqlSession sqlSession, int docNo); // 파일 삭제
	public List<AppDocument> selectAllRefDoc(SqlSession sqlSession, AppReference ref, PageInfo pi); // 참조 문서함 문서 조회
	public int selectListCountRef(SqlSession sqlSession, AppReference ref); // 참조 문서함 페이징
	public List<AppDocument> selectAllRefSearch(SqlSession sqlSession, Search search, PageInfo pi); // 참조 문서함 검색
	public int selectSearchRefCount(SqlSession sqlSession, Search search); // 참조 문서함 검색 페이징
	public List<AppDocument> selectAllAppDoc(SqlSession sqlSession, Approval app, PageInfo pi); // 결재 문서함 문서 조회
	public int selectListCountApp(SqlSession sqlSession, Approval app); // 결재 문서함 페이징
	public List<AppDocument> selectAllAppSearch(SqlSession sqlSession, Search search, PageInfo pi); // 결재 문서함 검색
	public int selectSearchAppCount(SqlSession sqlSession, Search search); // 결재 문서함 검색 페이징

}
