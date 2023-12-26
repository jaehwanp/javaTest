package com.bit.lms.model.dao;

import java.util.ArrayList;

import com.bit.lms.model.dto.ScoreDto;

public class ScoreDao {
	/*
	 * 	private int		num;		// 성적번호
	private int		testNum;	// 시험번호 (어떤시험이지 확인하기 위한 변수)
	private int		testScore;	// 시험점수
	 * 
	 * 
	 */
	//학생이 보는 자기성적
	public void myScore(int num){
		
	}
	
	
	//강사가 보는 모든 학생성적 목록
	public ArrayList<ScoreDto> ScoreList(){
		ArrayList<ScoreDto> list=new ArrayList<ScoreDto>();
		
		
		return list;
	}
	
	//학생성적입력
	public void addScore(int num, int testNum, int testScore){
		
	}
	
	//학생성적수정
	public void editScore(int num, int testNum, int testScore){
		
	}
	
}
