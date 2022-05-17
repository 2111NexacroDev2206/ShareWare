package org.kh.shareware.notice.service;

import java.util.List;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.notice.domain.Notice;


public interface NoticeService {
	//전체 게시글 개수
	int getListCount();
	//게시글 리스트 출력
	List<Notice> listNotice(PageInfo pi);
	//검색 게시글 개수
	int getSearchCount(Search search);
	//검색
	List<Search> printSearchNotice(Search search, PageInfo pi);
	//조회수 증가
	void countViewNotice(Integer noticeNo);
	//상세 페이지 보기
	Notice detailNotice(Integer noticeNo);
	// 홈 - 공지사항
	public List<Notice> homeNotice();

}
