package org.kh.shareware.common;

public class Search {
	private String memberNum;
	private String searchCondition;
	private String searchValue;
	
	public Search() {}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "Search [memberNum=" + memberNum + ", searchCondition=" + searchCondition + ", searchValue="
				+ searchValue + "]";
	}
	
}
