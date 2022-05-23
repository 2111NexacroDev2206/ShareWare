package org.kh.shareware.mail.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailBmk;
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
	
	@Override
	public List<MailRec> selectOneMailRec(SqlSession sqlSession, int mailNo) {
		List<MailRec> mailRec = sqlSession.selectList("MailMapper.selectOneMailRec", mailNo);
		return mailRec;
	}

	@Override
	public List<MailRef> selectOneMailRef(SqlSession sqlSession, int mailNo) {
		List<MailRef> mailRef = sqlSession.selectList("MailMapper.selectOneMailRef", mailNo);
		return mailRef;
	}

	@Override
	public List<MailFile> selectOneMailFile(SqlSession sqlSession, int mailNo) {
		List<MailFile> mailFile = sqlSession.selectList("MailMapper.selectOneMailFile", mailNo);
		return mailFile;
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
	public List<MailRec>selectOneTemMailRec(SqlSession sqlSession, int mailNo) {
		List<MailRec> mailRec = sqlSession.selectList("MailMapper.selectOneTemMailRec", mailNo);
		return mailRec;
	}

	@Override
	public List<MailRef>selectOneTemMailRef(SqlSession sqlSession, int mailNo) {
		List<MailRef> mailRef = sqlSession.selectList("MailMapper.selectOneTemMailRef", mailNo);
		return mailRef;
	}

	@Override
	public List<MailFile> selectOneTemMailFile(SqlSession sqlSession, int mailNo) {
		List<MailFile> mailFile = sqlSession.selectList("MailMapper.selectOneTemMailFile", mailNo);
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
	public List<MailRec> selectMailRecList(SqlSession sqlSession, MailRec mailRec) {
		List<MailRec> cList = sqlSession.selectList("MailMapper.selectMailRecList", mailRec);
		return cList;
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
	
	@Override
	public int updateICount(SqlSession sqlSession, int mailNo) {
		int count = sqlSession.update("MailMapper.viewCount", mailNo);
		return count;
	}


	@Override
	public int insertBmk(SqlSession sqlSession, MailBmk mailBmk) {
		int result = sqlSession.insert("MailMapper.insertBmk", mailBmk);
		return result;
	}

	@Override
	public int insertiMail(Mail mail, SqlSession sqlSession) {
		int mResult = sqlSession.insert("MailMapper.insertiMail", mail);
		return mResult;
	}
	@Override
	public int insertiMailRec(Mail mail, SqlSession sqlSession) {
		int mRecResult = sqlSession.insert("MailMapper.insertiMailRec", mail);
		return mRecResult;
	}

	@Override
	public int insertiMailMy(Mail mail, SqlSession sqlSession) {
		int mMyResult = sqlSession.insert("MailMapper.insertiMailMy", mail);
		return mMyResult;
	}

	@Override
	public int insertiMailFile(Mail mail, SqlSession sqlSession) {
		int mFileResult = sqlSession.insert("MailMapper.insertiMailFile", mail);
		return mFileResult;
	}

	@Override
	public int insertAppMail(Mail mail, SqlSession sqlSession) {
		int mResult = sqlSession.insert("MailMapper.insertAppMail", mail);
		return mResult;
	}

	@Override
	public int insertAppMailRec(MailRec mailRec, SqlSession sqlSession) {
		int mRecResult = sqlSession.insert("MailMapper.insertAppMailRec", mailRec);
		return mRecResult;
	}

	@Override
	public int insertAppMailRef(MailRef mailRef, SqlSession sqlSession) {
		int mRefResult = sqlSession.insert("MailMapper.insertAppMailRef", mailRef);
		return mRefResult;
	}

	@Override
	public int insertAppMailFile(MailFile mailFile, SqlSession sqlSession) {
		int mFileResult = sqlSession.insert("MailMapper.insertAppMailFile", mailFile);
		return mFileResult;
	}

	@Override
	public List<Mail> selectAppMail(Mail mail, SqlSession sqlSession) {
		List<Mail> aList = sqlSession.selectList("MailMapper.selectAppMail", mail);
		return aList;
	}

	@Override
	public List<Mail> selectSearchTemMail(SqlSession sqlSession, Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail> searchTemList = sqlSession.selectList("MailMapper.selectSearchTemList", search, rowBounds);
		return searchTemList;
	}

	@Override
	public List<Mail> selectSearchAppMail(SqlSession sqlSession, Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Mail> searchTemList = sqlSession.selectList("MailMapper.selectSearchAppList", search, rowBounds);
		return searchTemList;
	}

	@Override
	public int selectSearchListTemCount(SqlSession sqlSession, Search search) {
		int totalTemCount = sqlSession.selectOne("MailMapper.selectSearchTemCount", search);
		return totalTemCount;
	}

	@Override
	public int selectSearchListAppCount(SqlSession sqlSession, Search search) {
		int totalAppCount = sqlSession.selectOne("MailMapper.selectSearchAppCount", search);
		return totalAppCount;
	}

	@Override
	public Mail selectOneAppMail(SqlSession sqlSession, int mailNo) {
		Mail mail = sqlSession.selectOne("MailMapper.selectOneAppMail", mailNo);
		return mail;
	}

	@Override
	public List<MailRec> selectOneAppMailRec(SqlSession sqlSession, int mailNo) {
		List<MailRec> mailRec = sqlSession.selectList("MailMapper.selectOneAppMailRec", mailNo);
		return mailRec;
	}

	@Override
	public List<MailRef> selectOneAppMailRef(SqlSession sqlSession, int mailNo) {
		List<MailRef> mailRef = sqlSession.selectList("MailMapper.selectOneAppMailRef", mailNo);
		return mailRef;
	}

	@Override
	public List<MailFile> selectOneAppMailFile(SqlSession sqlSession, int mailNo) {
		List<MailFile> mailFile = sqlSession.selectList("MailMapper.selectOneAppMailFile", mailNo);
		return mailFile;
	}

	@Override
	public int selectAppListCount(SqlSession sqlSession, Mail mail) {
		int totalAppCount = sqlSession.selectOne("MailMapper.selectAppListCount", mail);
		return totalAppCount;
	}

	@Override
	public int selectReadListCount(SqlSession sqlSession, Mail mail) {
		int readTypeNCount = sqlSession.selectOne("MailMapper.selectReadListCount", mail);
		return readTypeNCount;
	}

	@Override
	public int selectIListCount(SqlSession sqlSession, Mail mail) {
		int totalICount = sqlSession.selectOne("MailMapper.selectIListCount", mail);
		return totalICount;
	}

	@Override
	public List<Mail> selectIMail(SqlSession sqlSession, Mail mail, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		 List<Mail> iList = sqlSession.selectList("MailMapper.selectIMail", mail, rowBounds);
		return iList;
	}

	@Override
	public Mail selectOneIMail(SqlSession sqlSession, int mailNo) {
		Mail mail = sqlSession.selectOne("MailMapper.selectOneIMail", mailNo);
		return mail;
	}

	@Override
	public List<MailRec> selectOneIMailRec(SqlSession sqlSession, int mailNo) {
		List<MailRec> mailRec = sqlSession.selectOne("MailMapper.selectOneIMailRec", mailNo);
		return mailRec;
	}

	@Override
	public List<MailRef> selectOneIMailRef(SqlSession sqlSession, int mailNo) {
		List<MailRef> mailRef = sqlSession.selectOne("MailMapper.selectOneIMailRef", mailNo);
		return mailRef;
	}

	@Override
	public List<MailFile> selectOneIMailFile(SqlSession sqlSession, int mailNo) {
		List<MailFile> mailFile = sqlSession.selectOne("MailMapper.selectOneIMailFile", mailNo);
		return mailFile;
	}

	@Override
	public List<MailBmk> selectBmk(SqlSession sqlSession, MailBmk mailBmk) {
		List<MailBmk> bList = sqlSession.selectList("MailMapper.selectBmk",mailBmk);
		return bList;
	}

	@Override
	public List<MailBmk> selectModalBmk(SqlSession sqlSession, MailBmk mailBmk) {
		List<MailBmk> bList = sqlSession.selectList("MailMapper.selectBmkList",mailBmk);
		return bList;
	}

	@Override
	public int selectReceiverCount(SqlSession sqlSession, Mail mail) {
		int cTotalCount = sqlSession.selectOne("MailMapper.selectReceiverCount", mail);
		return cTotalCount;
	}

	@Override
	public int deleteiMail(SqlSession sqlSession, int mailNo) {
		int result = sqlSession.delete("MailMapper.deleteiMail", mailNo);
		return result;
	}

	@Override
	public int deleteMailBmk(SqlSession sqlSession, MailBmk mailBmk) {
		int result = sqlSession.delete("MailMapper.deleteMailBmk", mailBmk);
		return result;
	}

	@Override
	public List<MailBmk> selectBmkList(SqlSession sqlSession, MailBmk mailBmk) {
		List<MailBmk> bmkList = sqlSession.selectList("MailMapper.selectBmkAllList",mailBmk);
		return bmkList;
	}

	
	

	

	

	


	
}
