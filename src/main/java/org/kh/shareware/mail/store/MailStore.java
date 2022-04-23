package org.kh.shareware.mail.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;

public interface MailStore {

	

	public int insertMail(Mail mail, SqlSession sqlSession);

	public int insertMailFile(MailFile mailFile, SqlSession sqlSession);

	public int insertMailRec(MailRec mailRec, SqlSession sqlSession);

	public int insertMailRef(MailRef mailRef, SqlSession sqlSession);

	public int insertTemMail(Mail mail, SqlSession sqlSession);
	
	public int insertTemMailRec(MailRec mailRec, SqlSession sqlSession);

	public int insertTemMailRef(MailRef mailRef, SqlSession sqlSession);

	public int insertTemMailFile(MailFile mailFile, SqlSession sqlSession);

	

	
	
}
