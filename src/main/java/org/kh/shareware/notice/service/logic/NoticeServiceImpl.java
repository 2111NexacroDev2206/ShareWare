package org.kh.shareware.notice.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.notice.domain.Notice;
import org.kh.shareware.notice.service.NoticeService;
import org.kh.shareware.notice.store.NoticeStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeStore nStore;
	@Autowired
	private SqlSession sqlsession;
	
	//게시판 총 게시물 개수
	@Override
	public int getListCount() {
		int result = nStore.selectClistCount(sqlsession);
		return result;
	}
	//리스트
	@Override
	public List<Notice> listNotice(PageInfo pi) {
		List<Notice> nList = nStore.selectAllNotice(sqlsession, pi);
		return nList;
	}
	//검색 글 개수 카운트
	@Override
	public int getSearchCount(Search search) {
		int result = nStore.selectSearchCount(sqlsession, search);
		return result;
	}
	@Override
	public List<Search> printSearchNotice(Search search, PageInfo pi) {
		List<Search> nList = nStore.selectSearchNotice(sqlsession, search, pi);
		return nList;
	}
	//조회수 증가
	@Override
	public void countViewNotice(Integer noticeNo) {
		nStore.countViewNotice(sqlsession, noticeNo);
		
	}
	//상세페이지 보기
	@Override
	public Notice detailNotice(Integer noticeNo) {
		Notice notice = nStore.selectOneNotice(sqlsession,noticeNo);
		return notice;
	}
	// 홈 - 공지사항
	@Override
	public List<Notice> homeNotice() {
		List<Notice> nList = nStore.selectAllHomeNotice(sqlsession);
		return nList;
	}
	//공지사항 삭제
	@Override
	public int registerNotice(String memberNum) {
		int result = nStore.insertNotice(sqlsession, memberNum);
		return result;
	}
	//공지사항 수정
	@Override
	public int modifyNotice(Notice notice) {
		int result = nStore.updateNotice(sqlsession, notice);
		return result;
	}
	//넥사크로 리스트
	@Override
	public List<Notice> adminlistNotice() {
		List<Notice> nList = nStore.selectAdminList(sqlsession);
		return nList;
	}
	//넥사크로 검색
	@Override
	public List<Notice> noticeSearchList(Search search) {
		List<Notice> nList = nStore.selectAdminSearch(sqlsession,search);
		return nList;
	}

}
