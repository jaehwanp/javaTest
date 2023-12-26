package com.bit.lms.model.dto;

import java.sql.Date;

public class AttendDto {
	//출결관리
	private int		num;			//출결번호
	private int		state;			//출결상태(1:출석,2:지각,3:조퇴,4:결석)
	private Date	attDate;		//출결일자
	private String	name;			//사용자이름
	
	//사용자
	private UserDto user;			//사용자번호(user.num)
	
	//getter, setter
	public AttendDto() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getAttDate() {
		return attDate;
	}

	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
