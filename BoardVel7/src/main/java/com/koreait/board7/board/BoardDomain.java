package com.koreait.board7.board;

public class BoardDomain extends BoardEntity{
	private String WriterNm;
	private String profileImg;
	
	
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getWriterNm() {
		return WriterNm;
	}

	public void setWriterNm(String writerNm) {
		WriterNm = writerNm;
	}
	
	
}
