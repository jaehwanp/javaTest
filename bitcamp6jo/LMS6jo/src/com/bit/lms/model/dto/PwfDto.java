package com.bit.lms.model.dto;

public class PwfDto {
	
	//비밀번호찾기
	private int num;		//비밀번호찾기 번호
	private String name;	//비밀번호찾기 질문명
	
	//생성자
	public PwfDto() {
		
	}
	
	//getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
