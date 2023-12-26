package com.bit.lms.model.dto;

public class DeptDto {
	
	//부서
	private int 	num;		//부서번호
	private String 	name;		//부서명(1:강사, 2:영업팀, 3:행정팀, 4:취업팀, 5:회계팀)
	
	//생성자
	public DeptDto() {
		
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
