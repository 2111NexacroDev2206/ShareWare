package org.kh.shareware.project.common;

public class Pagination {
	// PageInfo에 값을 세팅하는 역할
	public static PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		
		int docLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		boolean prev, next;
		maxPage = (int)((double)totalCount/docLimit + 0.9);
		startNavi = (((int)((double)currentPage/naviLimit+0.9))-1)*naviLimit +1;
		endNavi = startNavi + naviLimit -1;
		prev = startNavi > 1;
		next = endNavi < maxPage; 
		if(maxPage < endNavi) {
			endNavi = maxPage;
			
		}
		pi = new PageInfo(currentPage, docLimit, naviLimit, startNavi, endNavi, totalCount, maxPage, prev, next);
		return pi;
	}
}

