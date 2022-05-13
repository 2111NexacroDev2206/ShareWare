package org.kh.shareware.notice.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.notice.domain.Notice;
import org.kh.shareware.notice.store.NoticeStore;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeStoreLogic implements NoticeStore{
	//천체 개시물 개수
	@Override
	public int selectClistCount(SqlSession sqlsession) {
		int result = sqlsession.selectOne("NoticeMapper.selectClistCount");
		return result;
	}
	//리스트
	@Override
	public List<Notice> selectAllNotice(SqlSession sqlsession, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = sqlsession.selectList("NoticeMapper.noticeList",pi,rowBounds);
		return nList;
	}
	//전체 글 개수
	@Override
	public int selectSearchCount(SqlSession sqlsession, Search search) {
		int result = sqlsession.selectOne("NoticeMapper.selectNoticeSearchCount", search);
		return result;
	}
	//검색
	@Override
	public List<Search> selectSearchNotice(SqlSession sqlsession, Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Search> nList = sqlsession.selectList("NoticeMapper.searchNotice", search, rowBounds);
		return nList;
	}
	
	//조회수 증가
	@Override
	public void countViewNotice(SqlSession sqlsession, Integer noticeNo) {
		sqlsession.update("NoticeMapper.countViewNotice",noticeNo);
		
	}
	//상세보기
	@Override
	public Notice selectOneNotice(SqlSession sqlsession, Integer noticeNo) {
		Notice notice = sqlsession.selectOne("NoticeMapper.selectOneNotice",noticeNo);
		return notice;
	}

}
