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
	public List<MailRec> printMailRecList(MailRec mailRec);
	//받은 편지함
	public List<Mail> printMailRec(Mail mail, PageInfo pi);
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
	public int removeMail(int mailNo);

	public int removeMailRec(int mailNo);

	public int removeMailRef(int mailNo);

	public int removeMailFile(int mailNo);
	
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

	public int viewCountMail(int mailNo);
	
	public int registerMailBmk(MailBmk mailBmk);

	public int regiesteriMail(Mail mail);

	public int regiesteriMailRec(Mail mail);

	public int regiesteriMailMy(Mail mail);

	public int regiesteriMailFile(Mail mail);

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

	public int removeiMail(int mailNo);

//	public int removeiMailRec(Mail mail);
//
//	public int removeiMailMy(Mail mail);
//
//	public int removeiMailFile(Mail mail);

	public List<MailBmk> printModalBmk(MailBmk mailBmk);

	public int getReceiverCount(Mail mail);

	public int deleteMailBmk(int mailNo);

	 public List<MailBmk> printBmkList(MailBmk mailBmk);

	


	

	
	

	
	

	
	

	

	
	
	

	


	

	




	

	

	

}
