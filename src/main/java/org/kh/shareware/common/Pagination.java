package org.kh.shareware.common;

public class Pagination {
	// PageInfo에 값을 세팅하는 역할
	public static PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		
		int boardLimit = 5;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		
		maxPage = (int)((double)totalCount / boardLimit + 0.9); // 23 / 5 = 4.8 -> 4 이므로 double로 형변환 후 0.9 더해줌 5.7 -> int로 강제 형변환 5
		startNavi = ((int)((double)currentPage / naviLimit + 0.9) - 1) * naviLimit + 1; // 1 <- 1 ~ 5, 6 <- 6 ~ 10, 11 <- 11 ~ 15
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		pi = new PageInfo(currentPage, boardLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		return pi;
	}
}
