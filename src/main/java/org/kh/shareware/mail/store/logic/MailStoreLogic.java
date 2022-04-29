package org.kh.shareware.mail.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.domain.MailSearch;
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

	

	@Override
	public int deleteChkMail(SqlSession sqlSession, int values) {
		int result = sqlSession.delete("MailMapper.deleteChkMail", values);
		return result;
	}
	@Override
	public int deleteChkMailRec(SqlSession sqlSession, int values) {
		int result = sqlSession.delete("MailMapper.deleteChkMailRec", values);
		return result;
	}
	@Override
	public int deleteChkMailRef(SqlSession sqlSession, int values) {
		int result = sqlSession.delete("MailMapper.deleteChkMailRef", values);
		return result;
	}
	@Override
	public int deleteChkMailFile(SqlSession sqlSession,int values) {
		int result = sqlSession.delete("MailMapper.deleteChkMailFile", values);
		return result;
	}

	@Override
	public Mail selectOneMail(SqlSession sqlSession, int mailNo) {
		Mail mail = sqlSession.selectOne("MailMapper.selectOneMail", mailNo);
		return mail;
	}
	// 임시저장 목록
	@Override
	public List<Mail> selectTemMail(SqlSession sqlSession) {
		List<Mail>  tList = sqlSession.selectList("MailMapper.selectTemMail");
		return tList;
	}

	@Override
	public Mail selectOneTemMail(SqlSession sqlSession, int mailNo) {
		Mail mail = sqlSession.selectOne("MailMapper.selectOneTemMail", mailNo);
		return mail;
	}
	
	@Override
	public MailRec selectOneTemMailRec(SqlSession sqlSession, int mailNo) {
		MailRec mailRec = sqlSession.selectOne("MailMapper.selectOneTemMailRec", mailNo);
		return mailRec;
	}

	@Override
	public MailRef selectOneTemMailRef(SqlSession sqlSession, int mailNo) {
		MailRef mailRef = sqlSession.selectOne("MailMapper.selectOneTemMailRef", mailNo);
		return mailRef;
	}

	@Override
	public MailFile selectOneTemMailFile(SqlSession sqlSession, int mailNo) {
		MailFile mailFile = sqlSession.selectOne("MailMapper.selectOneTemMailFile", mailNo);
		return mailFile;
	}

	@Override
	public int deleteMail(SqlSession sqlSession, int mailNo) {
		int result = sqlSession.delete("MailMapper.deleteMail", mailNo);
		return result;
	}

	@Override
	public int deleteMailRec(SqlSession sqlSession, int mailNo) {
		int result = sqlSession.delete("MailMapper.deleteMailRec", mailNo);
		return result;

	}

	@Override
	public int deleteMailRef(SqlSession sqlSession, int mailNo) {
		int result = sqlSession.delete("MailMapper.deleteMailRef", mailNo);
		return result;

	}

	@Override
	public int deleteMailFile(SqlSession sqlSession, int mailNo) {
		int result = sqlSession.delete("MailMapper.deleteMailFile", mailNo);
		return result;

	}

	@Override
	public int updateTemMail(SqlSession sqlSession, Mail mail) {
		int result = sqlSession.update("MailMapper.updateTemMail", mail);
		return result;
	}

	@Override
	public int updateTemMailRec(SqlSession sqlSession, MailRec mailRec) {
		int result = sqlSession.update("MailMapper.updateTemMailRec", mailRec);
		return result;
	}

	@Override
	public int updateTemMailRef(SqlSession sqlSession, MailRef mailRef) {
		int result = sqlSession.update("MailMapper.updateTemMailRef", mailRef);
		return result;
	}

	@Override
	public int updateTemMailFile(SqlSession sqlSession, MailFile mailFile) {
		int result = sqlSession.update("MailMapper.updateTemMailFile", mailFile);
		return result;
	}

	//메일 검색기능
	@Override
	public List<Mail> selectSearchMail(SqlSession sqlSession, MailSearch mailSearch) {
		List<Mail> searchList = sqlSession.selectList("MailMapper.selectSearchList", mailSearch);
		return searchList;
	}

	@Override
	public List<MailRec> selectSearchRecMail(SqlSession sqlSession, MailSearch mailSearch) {
		List<MailRec> searchRecList = sqlSession.selectList("MailMapper.selectSearchRecList", mailSearch);
		return searchRecList;
	}

	@Override
	public List<Mail> selectSearchMyMail(SqlSession sqlSession, MailSearch mailSearch) {
		List<Mail> searchMyList = sqlSession.selectList("MailMapper.selectSearchMyList", mailSearch);
		return searchMyList;
	}

	@Override
	public List<MailFile> selectSearchFileMail(SqlSession sqlSession, MailSearch mailSearch) {
		List<MailFile> searchFileList = sqlSession.selectList("MailMapper.selectSearchFileList", mailSearch);
		return searchFileList;
	}

	//메일 목록
	@Override
	public List<Mail> selectMail(SqlSession sqlSession) {
		List<Mail>  mList = sqlSession.selectList("MailMapper.selectMail");
		return mList;
	}

	@Override
	public List<MailRec> selectRecMail(SqlSession sqlSession) {
		List<MailRec>  mRecList = sqlSession.selectList("MailMapper.selectRecMail");
		return mRecList;
	}

	@Override
	public List<Mail> selectMyMail(SqlSession sqlSession) {
		List<Mail>  mMyList = sqlSession.selectList("MailMapper.selectMyMail");
		return mMyList;
	}

	@Override
	public List<MailFile> selectFileMail(SqlSession sqlSession) {
		List<MailFile>  mFileList = sqlSession.selectList("MailMapper.selectFileMail");
		return mFileList;
	}

	


	
}
