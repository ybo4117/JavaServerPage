package com.koreait.board7.board;

public class BoardDTO {
	private int iboard;
	private int startIdx;
	private int recordCnt;
	private int searchType;
	private String searchText;

	public int getIboard() {
		return iboard;
	}

	public void setIboard(int iboard) {
		this.iboard = iboard;
	}

	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getStartIdx() {
		return startIdx;
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}

	public int getRecordCnt() {
		return recordCnt;
	}

	public void setRecordCnt(int recordCnt) {
		this.recordCnt = recordCnt;
	}

}
