package com.bit.lms.model.dto;

public class ScoreDto {
	
	//성적관리
	private int		num;		// 성적번호
	private int		testNum;	// 시험번호
	private int		testScore;	// 시험점수
	
	//사용자
	private UserDto	user;		// 사용자번호(user.num)
	
	public ScoreDto() {
		
	}

	//getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
	
	
}
