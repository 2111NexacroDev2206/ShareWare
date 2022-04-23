package org.kh.shareware.mail.service.logic;

import org.apache.ibatis.session.SqlSession;
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

}
