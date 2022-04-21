package org.kh.shareware.common;

public class Pagination {
	// PageInfo에 값을 세팅하는 역할
	public static PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		
		int memberLimit = 5;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		
		maxPage = (int)((double)totalCount / memberLimit + 0.9); 
		startNavi = ((int)((double)currentPage / naviLimit + 0.9) - 1); 
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		pi = new PageInfo(currentPage, memberLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		return pi;
	}
}
