package org.kh.shareware.mail.service;

import java.util.List;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
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
	public List<Mail> printMail(Mail mail, PageInfo pi);
	
	public List<Mail> printMailRec(Mail mail, PageInfo pi);

	public List<Mail> printMailMy(Mail mail, PageInfo pi);

	public List<Mail> printMailFile(Mail mail, PageInfo pi);
	
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
	
	
	//임시보관 상세
	public Mail printOneTemMail(int mailNo);
	
	public MailRec printOneTemMailRec(int mailNo);
	
	public MailRef printOneTemMailRef(int mailNo);

	public MailFile printOneTemMailFile(int mailNo);

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

	

	
	

	

	
	
	

	


	

	




	

	

	

}
