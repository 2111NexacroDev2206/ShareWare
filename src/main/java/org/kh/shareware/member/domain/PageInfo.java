package org.kh.shareware.member.domain;

public class PageInfo {

	private int currentPage; 
	private int memberLimit;  
	private int naviLimit;   
	private int startNavi;  
	private int endNavi;	
	private int totalCount;  
	private int maxPage;	
	private String searchKeyword;
	private String searchType;
	
	public PageInfo() {}


	public PageInfo(int currentPage, int memberLimit, int naviLimit, int startNavi, int endNavi, int totalCount,
			int maxPage) {
		super();
		this.currentPage = currentPage;
		this.memberLimit = memberLimit;
		this.naviLimit = naviLimit;
		this.startNavi = startNavi;
		this.endNavi = endNavi;
		this.totalCount = totalCount;
		this.maxPage = maxPage;
		this.searchKeyword = searchKeyword;
		this.searchType = searchType;
	}



	

	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getMemberLimit() {
		return memberLimit;
	}


	public void setMemberLimit(int memberLimit) {
		this.memberLimit = memberLimit;
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


	public String getSearchKeyword() {
		return searchKeyword;
	}


	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", qnaLimit=" + memberLimit + ", naviLimit=" + naviLimit
				+ ", startNavi=" + startNavi + ", endNavi=" + endNavi + ", totalCount=" + totalCount + ", maxPage="
				+ maxPage + "]";
	}


	
	


	

}
