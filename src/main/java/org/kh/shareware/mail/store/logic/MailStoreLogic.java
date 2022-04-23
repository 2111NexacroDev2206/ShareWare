package org.kh.shareware.mail.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.store.MailStore;
import org.springframework.stereotype.Repository;

@Repository
public class MailStoreLogic implements MailStore{

	@Override
	public int insertMail(Mail mail, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertMail",mail);
		return result;
	}

	@Override
	public int insertMailFile(MailFile mailFile, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertMailFile",mailFile);
		return result;
	}

	@Override
	public int insertMailRec(MailRec mailRec, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertMailRec",mailRec);
		return result;
	}

	@Override
	public int insertMailRef(MailRef mailRef, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertMailRef",mailRef);
		return result;
	}

	@Override
	public int insertTemMail(Mail mail, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertTemMail", mail);
		return result;
	}

	@Override
	public int insertTemMailRec(MailRec mailRec, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertTemMailRec", mailRec);
		return result;
	}

	@Override
	public int insertTemMailRef(MailRef mailRef, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertTemMailRef", mailRef);
		return result;
	}

	@Override
	public int insertTemMailFile(MailFile mailFile, SqlSession sqlSession) {
		int result = sqlSession.insert("MailMapper.insertTemMailFile", mailFile);
		return result;
	}



	
}
