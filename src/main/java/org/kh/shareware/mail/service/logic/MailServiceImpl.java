package org.kh.shareware.mail.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.service.MailService;
import org.kh.shareware.mail.store.MailStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MailServiceImpl implements MailService{
	@Autowired
	MailStore mStore;
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int registerMail(Mail mail) {
		int result = mStore.insertMail( mail,sqlSession);
		return result;
	}


	@Override
	public int registerMailFile(MailFile mailFile) {
		int result = mStore.insertMailFile(mailFile,sqlSession);
		return result;
	}


	@Override
	public int registerMailRec(MailRec mailRec) {
		int result = mStore.insertMailRec(mailRec, sqlSession);
		return result;
	}


	@Override
	public int registerMailRef(MailRef mailRef) {
		int result = mStore.insertMailRef(mailRef, sqlSession);
		return result;
	}


	@Override
	public int registerTemMail(Mail mail) {
		int result = mStore.insertTemMail(mail,sqlSession);
		return result;
	}


	@Override
	public int registerTemMailRec(MailRec mailRec) {
		int result = mStore.insertTemMailRec(mailRec,sqlSession);
		return result;
	}


	@Override
	public int registerTemMailRef(MailRef mailRef) {
		int result = mStore.insertTemMailRef(mailRef, sqlSession);
		return result;
	}


	@Override
	public int registerTemMailMyFile(MailFile mailFile) {
		int result = mStore.insertTemMailFile(mailFile, sqlSession);
		return result;
	}


	


	@Override
	public int removeChkMail( int values) {
		int result = mStore.deleteChkMail(sqlSession, values);
		return result;
	}


	@Override
	public int removeChkMailRec(int values) {
		int result = mStore.deleteChkMailRec(sqlSession, values);
		return result;
	}
	


	@Override
	public int removeChkMailRef(int values) {
		int result = mStore.deleteChkMailRef(sqlSession, values);
		return result;
	}


	@Override
	public int removeChkMailFile(int values) {
		int result = mStore.deleteChkMailFile(sqlSession, values);
		return result;
	}


	@Override
	public Mail printOneMail(int mailNo) {
		Mail mail = mStore.selectOneMail(sqlSession, mailNo);
		return mail;
	}


	@Override
	public List<Mail> printTemMail(Mail mail, PageInfo pi) {
		List<Mail> tList = mStore.selectTemMail(sqlSession, mail, pi);
		return tList;
	}
	
	@Override
	public int getTemMailCount(Mail mail) {
		int totalCount = mStore.selectTemListCount(sqlSession, mail);
		return totalCount;
	}


	@Override
	public Mail printOneTemMail(int mailNo) {
		Mail mail = mStore.selectOneTemMail(sqlSession, mailNo);
		return mail;
	}

	@Override
	public MailRec printOneTemMailRec(int mailNo) {
		MailRec mailRec = mStore.selectOneTemMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public MailRef printOneTemMailRef(int mailNo) {
		MailRef mailRef = mStore.selectOneTemMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public MailFile printOneTemMailFile(int mailNo) {
		MailFile mailFile = mStore.selectOneTemMailFile(sqlSession, mailNo);
		return mailFile;
	}
	


	@Override
	public int removeMail(int mailNo) {
		int result = mStore.deleteMail(sqlSession, mailNo);
		return result;
	}


	@Override
	public int removeMailRec(int mailNo) {
		int result = mStore.deleteMailRec(sqlSession, mailNo);
		return result;
	}


	@Override
	public int removeMailRef(int mailNo) {
		int result = mStore.deleteMailRef(sqlSession, mailNo);
		return result;
	}


	@Override
	public int removeMailFile(int mailNo) {
		int result = mStore.deleteMailFile(sqlSession, mailNo);
		return result;
	}


	@Override
	public int modifyTemMail(Mail mail) {
		int result = mStore.updateTemMail(sqlSession, mail);
		return result;
	}


	@Override
	public int modifyTemMailRec(MailRec mailRec) {
		int result = mStore.updateTemMailRec(sqlSession, mailRec);
		return result;
	}


	@Override
	public int modifyTemMailRef(MailRef mailRef) {
		int result = mStore.updateTemMailRef(sqlSession, mailRef);
		return result;
	}


	@Override
	public int modifyTemMailFile(MailFile mailFile) {
		int result = mStore.updateTemMailFile(sqlSession, mailFile);
		return result;
	}


	@Override
	public List<Mail> printSearchMail(Search search, PageInfo pi) {
		List<Mail> searchList = mStore.selectSearchMail(sqlSession, search, pi);
		return searchList;
	}


	@Override
	public List<Mail> printSearchMailRec(Search search, PageInfo pi) {
		List<Mail> searchRecList = mStore.selectSearchRecMail(sqlSession, search, pi);
		return searchRecList;
	}


	@Override
	public List<Mail> printSearchMailMy(Search search, PageInfo pi) {
		List<Mail> searchMyList = mStore.selectSearchMyMail(sqlSession, search, pi);
		return searchMyList;
	}


	@Override
	public List<Mail> printSearchMailFile(Search search, PageInfo pi) {
		List<Mail> searchFileList = mStore.selectSearchFileMail(sqlSession, search, pi);
		return searchFileList;
	}


	@Override
	public List<Mail> printMail(Mail mail, PageInfo pi) {
		List<Mail> mList = mStore.selectMail(sqlSession, mail, pi);
		return mList;
	}


	@Override
	public List<Mail> printMailRec(Mail mail, PageInfo pi) {
		List<Mail> mRecList = mStore.selectRecMail(sqlSession, mail, pi);
		return mRecList;
	}


	@Override
	public List<Mail> printMailMy(Mail mail, PageInfo pi) {
		List<Mail> mMyList = mStore.selectMyMail(sqlSession, mail, pi);
		return mMyList;
	}


	@Override
	public List<Mail> printMailFile(Mail mail, PageInfo pi) {
		List<Mail> mFileList = mStore.selectFileMail(sqlSession, mail, pi);
		return mFileList;
	}


	@Override
	public int getMailCount(Mail mail) {
		int totalmCount = mStore.selectMailCount(sqlSession, mail);
		return totalmCount;
	}


	@Override
	public int getMailRecCount(Mail mail) {
		int totalmRecCount = mStore.selectMailRecCount(sqlSession, mail);
		return totalmRecCount;
	}


	@Override
	public int getMailMyCount(Mail mail) {
		int totalmMyCount = mStore.selectMailMyCount(sqlSession, mail);
		return totalmMyCount;
	}


	@Override
	public int getMailFileCount(Mail mail) {
		int totalmFileCount = mStore.selectMailFileCount(sqlSession, mail);
		return totalmFileCount;
	}

	@Override
	public int getSearchMailCount(Search search) { //메일함 검색 페이징
		int totalmCount = mStore.selectSearchListCount(sqlSession, search);
		return totalmCount;
	}

	@Override
	public int getSearchMailRecCount(Search search) {
		int totalmRecCount = mStore.selectSearchListRecCount(sqlSession, search);
		return totalmRecCount;
	}


	@Override
	public int getSearchMailMyCount(Search search) {
		int totalmMyCount = mStore.selectSearchListMyCount(sqlSession, search);
		return totalmMyCount;
	}


	@Override
	public int getSearchMailFileCount(Search search) {
		int totalmFileCount = mStore.selectSearchListFileCount(sqlSession, search);
		return totalmFileCount;
	}


	


	

	
	





	

}
