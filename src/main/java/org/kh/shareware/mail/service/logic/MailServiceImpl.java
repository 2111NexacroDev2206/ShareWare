package org.kh.shareware.mail.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailBmk;
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
	public List<MailRec> printOneMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneMailRec(sqlSession, mailNo);
		return mailRec;
	}
	


	@Override
	public List<MailRef> printOneMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneMailFile(sqlSession, mailNo);
		return mailFile;
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
	public List<MailRec> printOneTemMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneTemMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneTemMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneTemMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneTemMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneTemMailFile(sqlSession, mailNo);
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
	public List<MailRec> printMailRecList(MailRec mailRec) {
		List<MailRec> cList = mStore.selectMailRecList(sqlSession, mailRec);
		return cList;
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


	@Override
	public int viewCountMail(int mailNo) {
		int count = mStore.updateICount(sqlSession, mailNo);
		return count;
	}

	@Override
	public int registerMailBmk(MailBmk mailBmk) {
		int result = mStore.insertBmk(sqlSession, mailBmk);
		return result;
	}


	@Override
	public int regiesteriMailRec(Mail mail) {
		int mRecResult = mStore.insertiMailRec(mail, sqlSession);
		return mRecResult;
	}

	@Override
	public int regiesteriMail(Mail mail ){
		int mResult = mStore.insertiMail(mail, sqlSession);
		return mResult;
		
	}
	@Override
	public int regiesteriMailMy(Mail mail) {
		int mMyResult = mStore.insertiMailMy(mail, sqlSession);
		return mMyResult;
	}
	@Override
	public int regiesteriMailFile(Mail mail) {
		int mFileResult = mStore.insertiMailFile(mail, sqlSession);
		return mFileResult;
	}


	


	@Override
	public int registerAppMail(Mail mail) {
		int mResult = mStore.insertAppMail(mail, sqlSession);
		return mResult;
	}


	@Override
	public int registerAppMailRec(MailRec mailRec) {
		int mRecResult = mStore.insertAppMailRec(mailRec, sqlSession);
		return mRecResult;
	}


	@Override
	public int registerAppMailRef(MailRef mailRef) {
		int mRefResult = mStore.insertAppMailRef(mailRef, sqlSession);
		return mRefResult;
	}


	@Override
	public int registerAppMailFile(MailFile mailFile) {
		int mFileResult = mStore.insertAppMailFile(mailFile, sqlSession);
		return mFileResult;
	}


	@Override
	public List<Mail> printAppMail(Mail mail, PageInfo pi) {
		List<Mail> aList = mStore.selectAppMail(mail, sqlSession);
		return aList;
	}


	@Override
	public List<Mail> printSearchTemMail(Search search, PageInfo pi) {
		List<Mail> searchTemList = mStore.selectSearchTemMail(sqlSession, search, pi);
		return searchTemList;
	}


	@Override
	public List<Mail> printSearchAppMail(Search search, PageInfo pi) {
		List<Mail> searchAppList = mStore.selectSearchAppMail(sqlSession, search, pi);
		return searchAppList;
	}


	@Override
	public int getSearchTemMailCount(Search search) {
		int totalTemCount = mStore.selectSearchListTemCount(sqlSession,search );
		return totalTemCount;
	}


	@Override
	public int getSearchAppMailCount(Search search) {
		int totalAppCount = mStore.selectSearchListAppCount(sqlSession,search );
		return totalAppCount;
	}


	@Override
	public Mail printOneAppMail(int mailNo) {
		Mail mail = mStore.selectOneAppMail(sqlSession, mailNo);
		return mail;
	}


	@Override
	public List<MailRec> printOneAppMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneAppMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneAppMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneAppMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneAppMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneAppMailFile(sqlSession, mailNo);
		return mailFile;
	}


	@Override
	public int getAppMailCount(Mail mail) {
		int totalAppCount = mStore.selectAppListCount(sqlSession, mail);
		return totalAppCount;
	}


	@Override
	public int getMailReadCount(Mail mail) {
		int readTypeNCount = mStore.selectReadListCount(sqlSession,mail);
		return readTypeNCount;
	}


	@Override
	public int getIMailCount(Mail mail) {
		int totalICount = mStore.selectIListCount(sqlSession, mail);
		return totalICount;
	}


	@Override
	public List<Mail> printIMail(Mail mail, PageInfo pi) {
		List<Mail> iList = mStore.selectIMail(sqlSession, mail, pi);
		return iList;
	}


	@Override
	public Mail printOneIMail(int mailNo) {
		Mail mail = mStore.selectOneIMail(sqlSession, mailNo);
		return mail;
	}


	@Override
	public List<MailRec> printOneIMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneIMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneIMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneIMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneIMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneIMailFile(sqlSession, mailNo);
		return mailFile;
	}


	@Override
	public List<MailBmk> printBmk(MailBmk mailBmk) {
		List<MailBmk> bList = mStore.selectBmk(sqlSession, mailBmk);
		return bList;
	}


	@Override
	public int removeiMail(int mailNo) {
		int result = mStore.deleteiMail(sqlSession, mailNo);
		return result;
	}


	

	//모달 즐겨찾는 그룹 목록 
	@Override
	public List<MailBmk> printModalBmk(MailBmk mailBmk) {
		List<MailBmk> bList = mStore.selectModalBmk(sqlSession, mailBmk);
		return bList;
	}


	@Override
	public int getReceiverCount(Mail mail) {
		int cTotalCount = mStore.selectReceiverCount(sqlSession, mail);
		return cTotalCount;
	}


	@Override
	public int deleteMailBmk(int mailNo) {
		int result = mStore.deleteMailBmk(sqlSession, mailNo);
		return result;
	}


	

	


	

	

	


	

	
	





	

}
