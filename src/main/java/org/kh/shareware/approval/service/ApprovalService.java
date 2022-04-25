package org.kh.shareware.approval.service;

import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;

public interface ApprovalService {

	public int registerDoc(AppDocument appDoc); // 기안서 등록
	public int registerApp(Approval app); // 결재자 등록
	public int registerRef(AppReference ref); // 참조자 등록

}
