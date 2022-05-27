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
	//공지사항 글 작성 넥사크로
	int registerNotice(Notice newNotice);
	//공지사항 수정
	int modifyNotice(Notice newNotice);
	//넥사크로 리스트 
	List<Notice> adminlistNotice();
	//넥사크로 검색
	List<Notice> noticeSearchList(Search search);
	//넥사크로 상세보기 페이지
	Notice adminNoticeDetail(int noticeNo);
	//넥사크로 공지사항삭제
	int removeNotice(int noticeNo);
	//알림 최근 공지 조회
	public Notice printLastNotice();
	

}
