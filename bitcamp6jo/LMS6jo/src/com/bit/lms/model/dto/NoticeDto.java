package com.bit.lms.model.dto;

import java.sql.Date;

public class NoticeDto {
	
	//공지사항(test)
	private int 	num;			//공지사항 번호
	private String	subject;		//공지사항 제목
	private String	content;		//공지사항 내용
	private Date	regdate;		//공지사항 등록일자
	private int		topstate;		//공지사항 상단노출상태값(0:공지사항x, 1:공지사항o)
	
	//관리자 객체 객체 객체
	private AdminDto admin;		//관리자번호(admin.num)
	
	public NoticeDto() {
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getTopstate() {
		return topstate;
	}

	public void setTopstate(int topstate) {
		this.topstate = topstate;
	}

	public AdminDto getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDto admin) {
		this.admin = admin;
	}
	
	
	
}
