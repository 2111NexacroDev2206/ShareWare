package org.kh.shareware.mail.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
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
	public List<Mail> selectTemMail(SqlSession sqlSession, Mail mail, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail>  tList = sqlSession.selectList("MailMapper.selectTemMail", mail, rowBounds);
		return tList;
	}
	
	@Override
	public int selectTemListCount(SqlSession sqlSession, Mail mail) {
		int totalCount = sqlSession.selectOne("MailMapper.selectTemListCount", mail);
		return totalCount;
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
	public List<Mail> selectSearchMail(SqlSession sqlSession,Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail> searchList = sqlSession.selectList("MailMapper.selectSearchList", search, rowBounds);
		return searchList;
	}

	@Override
	public List<Mail> selectSearchRecMail(SqlSession sqlSession,Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail> searchRecList = sqlSession.selectList("MailMapper.selectSearchRecList", search, rowBounds);
		return searchRecList;
	}

	@Override
	public List<Mail> selectSearchMyMail(SqlSession sqlSession,Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail> searchMyList = sqlSession.selectList("MailMapper.selectSearchMyList", search, rowBounds);
		return searchMyList;
	}

	@Override
	public List<Mail> selectSearchFileMail(SqlSession sqlSession, Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail> searchFileList = sqlSession.selectList("MailMapper.selectSearchFileList", search, rowBounds);
		return searchFileList;
	}

	//메일 목록
	@Override
	public List<Mail> selectMail(SqlSession sqlSession, Mail mail, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail>  mList = sqlSession.selectList("MailMapper.selectMail", mail, rowBounds);
		return mList;
	}

	@Override
	public List<Mail> selectRecMail(SqlSession sqlSession, Mail mail, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail>  mRecList = sqlSession.selectList("MailMapper.selectRecMail", mail, rowBounds);
		return mRecList;
	}

	@Override
	public List<Mail> selectMyMail(SqlSession sqlSession, Mail mail, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail>  mMyList = sqlSession.selectList("MailMapper.selectMyMail", mail, rowBounds);
		return mMyList;
	}

	@Override
	public List<Mail> selectFileMail(SqlSession sqlSession, Mail mail, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail>  mFileList = sqlSession.selectList("MailMapper.selectFileMail", mail, rowBounds);
		return mFileList;
	}

	@Override
	public int selectMailCount(SqlSession sqlSession, Mail mail) {
		int totalmCount = sqlSession.selectOne("MailMapper.selectMailCount", mail);
		return totalmCount;
	}

	@Override
	public int selectMailRecCount(SqlSession sqlSession, Mail mail) {
		int totalmRecCount = sqlSession.selectOne("MailMapper.selectMailRecCount", mail);
		return totalmRecCount;
	}

	@Override
	public int selectMailMyCount(SqlSession sqlSession, Mail mail) {
		int totalmMyCount = sqlSession.selectOne("MailMapper.selectMailMyCount", mail);
		return totalmMyCount;
	}

	@Override
	public int selectMailFileCount(SqlSession sqlSession, Mail mail) {
		int totalmFileCount = sqlSession.selectOne("MailMapper.selectMailFileCount", mail);
		return totalmFileCount;
	}

	@Override
	public int selectSearchListCount(SqlSession sqlSession, Search search) {
		int totalmCount = sqlSession.selectOne("MailMapper.selectSearchCount", search);
		return totalmCount;
	}
	@Override
	public int selectSearchListRecCount(SqlSession sqlSession, Search search) {
		int totalmRecCount = sqlSession.selectOne("MailMapper.selectSearchRecCount", search);
		return totalmRecCount;
	}

	@Override
	public int selectSearchListMyCount(SqlSession sqlSession, Search search) {
		int totalmMyCount = sqlSession.selectOne("MailMapper.selectSearchMyCount", search);
		return totalmMyCount;
	}

	@Override
	public int selectSearchListFileCount(SqlSession sqlSession, Search search) {
		int totalmFileCount = sqlSession.selectOne("MailMapper.selectSearchFileCount", search);
		return totalmFileCount;
	}

	

	

	


	
}
