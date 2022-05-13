package org.kh.shareware.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.notice.domain.Notice;

public interface NoticeStore {

	int selectClistCount(SqlSession sqlsession);

	List<Notice> selectAllNotice(SqlSession sqlsession, PageInfo pi);
	//검색 글 개수
	int selectSearchCount(SqlSession sqlsession, Search search);
	//검색
	List<Search> selectSearchNotice(SqlSession sqlsession, Search search, PageInfo pi);
	//조회수 증가
	void countViewNotice(SqlSession sqlsession, Integer noticeNo);
	//상세보기
	Notice selectOneNotice(SqlSession sqlsession, Integer noticeNo);

}
