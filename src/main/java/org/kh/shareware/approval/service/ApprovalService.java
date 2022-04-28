package org.kh.shareware.approval.service;

import java.util.List;

import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.common.PageInfo;

public interface ApprovalService {

	public int registerDoc(AppDocument appDoc); // 기안서 등록
	public int registerApp(Approval app); // 결재자 등록
	public int registerRef(AppReference ref); // 참조자 등록
	public int registerFile(AppFile file); // 파일 등록
	public AppForm printForm(int formNo); // 문서 양식 조회
	public List<AppForm> printAllForm(); // 문서 양식 전체 조회
	public String printOneLeaveDoc(String memberNum); // 휴가 신청서 조회(잔여 연차)
	public List<AppDocument> printAll(String memberNum, PageInfo pi); // 기안 문서 조회(기안 문서함)
	public int getListCount(String memberNum); // 기안 문서함 페이징 처리

}
