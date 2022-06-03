package org.kh.shareware.mail.service;

import java.util.List;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailBmk;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;


public interface MailService {

	
	//메일 발송
	public int registerMail(Mail mail);

	public int registerMailFile(MailFile mailFile);

	public int registerMailRec(MailRec mailRec);

	public int registerMailRef(MailRef mailRef);
	
	//임시보관 메일 등록
	public int registerTemMail(Mail mail);

	public int registerTemMailRec(MailRec mailRec);

	public int registerTemMailRef(MailRef mailRef);

	public int registerTemMailMyFile(MailFile mailFile);
	
	//메일함 목록
	//보낸 편지함
	public List<Mail> printMail(Mail mail, PageInfo pi);
	//받은 편지함
	public List<Mail> printMailRec(Mail mail, PageInfo pi);
	//수신인 리스트
	public List<MailRec> printMailRecList(MailRec mailRec);
	//참조인 리스트
	public List<MailRef> printMailRefList(MailRef mailRef);
	// 내게 쓴 편지함
	public List<Mail> printMailMy(Mail mail, PageInfo pi);
	//파일 첨부함
	public List<Mail> printMailFile(Mail mail, PageInfo pi);
	
	//승인메일함 목록
	public List<Mail> printAppMail(Mail mail, PageInfo pi);
	
	//임시 보관함 목록
	public List<Mail> printTemMail(Mail mail, PageInfo pi);
	
	public int getTemMailCount(Mail mail);

	//목록에서 체크한 메일 삭제
	public int removeChkMail( int values);

	public int removeChkMailRec(int values);

	public int removeChkMailRef(int values);

	public int removeChkMailFile(int values);
	
	//메일 상세 
	public Mail printOneMail(int mailNo);
	
	public List<MailRec> printOneMailRec(int mailNo);

	public List<MailRef> printOneMailRef(int mailNo);

	public List<MailFile> printOneMailFile(int mailNo);

	
	//임시보관 상세
	public Mail printOneTemMail(int mailNo);
	
	public List<MailRec> printOneTemMailRec(int mailNo);
	
	public List<MailRef> printOneTemMailRef(int mailNo);

	public List<MailFile> printOneTemMailFile(int mailNo);

	//임시보관수정
	public int modifyTemMail(Mail mail);

	public int modifyTemMailRec(MailRec mailRec);

	public int modifyTemMailRef(MailRef mailRef);

	public int modifyTemMailFile(MailFile mailFile);
	
	
	//메일 삭제
	public int removeMail(int values);

	public int removeMailRec(int values);

	public int removeMailRef(int values);
	
	//메일 검색 목록
	public List<Mail> printSearchMail(Search search, PageInfo pi);

	public List<Mail> printSearchMailRec(Search search, PageInfo pi);

	public List<Mail> printSearchMailFile(Search search, PageInfo pi);

	public List<Mail> printSearchMailMy(Search search, PageInfo pi);

	public int getMailCount(Mail mail);

	public int getMailRecCount(Mail mail);

	public int getMailMyCount(Mail mail);

	public int getMailFileCount(Mail mail);
	
	public int getSearchMailCount(Search search);

	public int getSearchMailRecCount(Search search);

	public int getSearchMailMyCount(Search search);

	public int getSearchMailFileCount(Search search);
	//메일 읽은메일 카운트
	public int viewCountMail(Mail mail);
	
	public int viewRecCountMail(Mail mail);

	public int viewRefCountMail(Mail mail);
	
	public int registerMailBmk(MailBmk mailBmk);
	//즐겨찾는 메일 등록
	public int regiesteriMail(int values);

	public int regiesteriMailRec(int values);

	public int regiesteriMailRef(int values);


	public int registerAppMail(Mail mail);

	public int registerAppMailRec(MailRec mailRec);

	public int registerAppMailRef(MailRef mailRef);

	public int registerAppMailFile(MailFile mailFile);

	public List<Mail> printSearchTemMail(Search search, PageInfo pi);
	
	public List<Mail> printSearchAppMail(Search search, PageInfo pi);
	
	public int getSearchTemMailCount(Search search);

	public int getSearchAppMailCount(Search search);
	
	//승인 메일 상세

	public Mail printOneAppMail(int mailNo);

	public List<MailRec> printOneAppMailRec(int mailNo);

	public List<MailRef> printOneAppMailRef(int mailNo);

	public List<MailFile> printOneAppMailFile(int mailNo);

	public int getAppMailCount(Mail mail);

	public int getMailReadCount(Mail mail);

	public int getIMailCount(Mail mail);

	public List<Mail> printIMail(Mail mail, PageInfo pi);

	public Mail printOneIMail(int mailNo);

	public List<MailRec> printOneIMailRec(int mailNo);

	public List<MailRef> printOneIMailRef(int mailNo);

	public List<MailFile> printOneIMailFile(int mailNo);

	public List<MailBmk> printBmk(MailBmk mailBmk);
	//즐겨찾는 메일 삭제
	public int removeiMail(int values);

	public int removeiMailRec(int values);

	public int removeiMailRef(int values);


	public List<MailBmk> printModalBmk(MailBmk mailBmk);

	public int getReceiverCount(Mail mail);
	
	public int getRefereeCount(Mail mail);

	public int deleteMailBmk(MailBmk mailBmk);

	 public List<MailBmk> printBmkList(MailBmk mailBmk);

	public int printMailNo(Mail mail);
	// 메일 발송시 즐겨찾는 그룹 선택 그룹원
	public List<MailBmk> printOneMailBmk(MailBmk mailBmk);
	
	// 넥사크로 - 승인 메일 관리
	public List<Mail> printAllAppMail(); // 승인 메일 전체 조회

	public int printAppCount(); // 승인 대기 메일 개수

	public List<Mail> printSearchAppMail(String searchValue); // 승인 메일 검색

	public int printAppAllCount(); // 전체 승인 메일 개수

	public Mail adminPrintOneAppMail(int mailNo); // 승인 메일 상세 조회

	public List<Mail> printFilterAppMail(String aStatus); // 승인 상태 필터 조회

	public int deleteAppMail(String mailNo); // 승인 메일 삭제

	public int modifyAppMailStatus(Mail mail); // 승인 상태 변경
	
	
	

	

	

	


	

	
	

	
	

	
	

	

	
	
	

	


	

	




	

	

	

}
