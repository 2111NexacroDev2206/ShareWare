package org.kh.shareware.common;

public class PageInfo {
		// 페이지 네비를 만들기 위해 필요한 변수
		private int currentPage; 	// 현재 페이지
		private int docLimit; 		// 한 페이지당 게시글 개수
		private int naviLimit; 		// 한 페이지당 pageNavi 개수
		private int startNavi; 		// pageNavi 시작값
		private int endNavi; 		// pageNavi 끝값
		private int totalCount; 	// 전체 게시글 개수
		private int maxPage; 		// 페이지의 마지막 번호
		private boolean prev;  		// 이전
		private boolean next; 		// 다음
		
		public PageInfo() {}

		public PageInfo(int currentPage, int docLimit, int naviLimit, int startNavi, int endNavi, int totalCount,
				int maxPage, boolean prev, boolean next) {
			super();
			this.currentPage = currentPage;
			this.docLimit = docLimit;
			this.naviLimit = naviLimit;
			this.startNavi = startNavi;
			this.endNavi = endNavi;
			this.totalCount = totalCount;
			this.maxPage = maxPage;
			this.prev = prev;
			this.next = next;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getDocLimit() {
			return docLimit;
		}

		public void setDocLimit(int docLimit) {
			this.docLimit = docLimit;
		}

		public int getNaviLimit() {
			return naviLimit;
		}

		public void setNaviLimit(int naviLimit) {
			this.naviLimit = naviLimit;
		}

		public int getStartNavi() {
			return startNavi;
		}

		public void setStartNavi(int startNavi) {
			this.startNavi = startNavi;
		}

		public int getEndNavi() {
			return endNavi;
		}

		public void setEndNavi(int endNavi) {
			this.endNavi = endNavi;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getMaxPage() {
			return maxPage;
		}

		public void setMaxPage(int maxPage) {
			this.maxPage = maxPage;
		}

		public boolean isPrev() {
			return prev;
		}

		public void setPrev(boolean prev) {
			this.prev = prev;
		}

		public boolean isNext() {
			return next;
		}

		public void setNext(boolean next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "PageInfo [currentPage=" + currentPage + ", docLimit=" + docLimit + ", naviLimit=" + naviLimit
					+ ", startNavi=" + startNavi + ", endNavi=" + endNavi + ", totalCount=" + totalCount + ", maxPage="
					+ maxPage + ", prev=" + prev + ", next=" + next + "]";
		}

}
