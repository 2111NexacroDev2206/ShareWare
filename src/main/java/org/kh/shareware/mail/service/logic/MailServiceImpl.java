package org.kh.shareware.mail.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.domain.MailSearch;
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
	public List<Mail> printTemMail() {
		List<Mail> tList = mStore.selectTemMail(sqlSession);
		return tList;
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
	public List<Mail> printSearchMail(MailSearch mailSearch) {
		List<Mail> searchList = mStore.selectSearchMail(sqlSession, mailSearch);
		return searchList;
	}


	@Override
	public List<MailRec> printSearchMailRec(MailSearch mailSearch) {
		List<MailRec> searchRecList = mStore.selectSearchRecMail(sqlSession, mailSearch);
		return searchRecList;
	}


	@Override
	public List<Mail> printSearchMailMy(MailSearch mailSearch) {
		List<Mail> searchMyList = mStore.selectSearchMyMail(sqlSession, mailSearch);
		return searchMyList;
	}


	@Override
	public List<MailFile> printSearchMailFile(MailSearch mailSearch) {
		List<MailFile> searchFileList = mStore.selectSearchFileMail(sqlSession, mailSearch);
		return searchFileList;
	}


	@Override
	public List<Mail> printMail() {
		List<Mail> mList = mStore.selectMail(sqlSession);
		return mList;
	}


	@Override
	public List<MailRec> printMailRec() {
		List<MailRec> mRecList = mStore.selectRecMail(sqlSession);
		return mRecList;
	}


	@Override
	public List<Mail> printMailMy() {
		List<Mail> mMyList = mStore.selectMyMail(sqlSession);
		return mMyList;
	}


	@Override
	public List<MailFile> printMailFile() {
		List<MailFile> mFileList = mStore.selectFileMail(sqlSession);
		return mFileList;
	}


	
	





	

}
