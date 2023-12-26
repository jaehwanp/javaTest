package com.bit.lms.model.dto;

import java.sql.Date;

public class UserDto {
	
	//사용자
	private int 		num;		//사용자번호
	private String 		id;			//사용자아이디
	private String 		name;		//사용자이름 
	private String 		pw1;		//패스워드
	private String 		pw2;		//패스워드확인
	private String  	cp;			//핸드폰번호
	private String 		email;		//이메일
	private int 		sex;		//성별
	private int			subject;	//희망강좌(1:Java반, 2:DB반, 3:Web반)
	private Date		regdate;	//등록일자
	private int			state;		//상태값(0:가입, 1:회원탈퇴대기)
	private String		pwA;		//비밀번호답
	private int			joinPath;	//가입경로(1:인터넷광고,2:고용센터추천,3:지인추천)
	private int 		pwfno;		//비번찾기 질문
	
	public int getPwfno() {
		return pwfno;
	}

	public void setPwfno(int pwfno) {
		this.pwfno = pwfno;
	}

	//강좌
	private SubjectDto	sub;		//강좌번호(sub.num)
	
	//비밀번호찾기
	private AdminDto	pwf;		//비밀번호찾기번호(pwf.num)
	
	//기본생성자
	public UserDto() {
		
	}
	
	//getter(),setter()
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getPwA() {
		return pwA;
	}

	public void setPwA(String pwA) {
		this.pwA = pwA;
	}

	public int getJoinPath() {
		return joinPath;
	}

	public void setJoinPath(int joinPath) {
		this.joinPath = joinPath;
	}

	public SubjectDto getSub() {
		return sub;
	}

	public void setSub(SubjectDto sub) {
		this.sub = sub;
	}

	public AdminDto getPwfNum() {
		return pwf;
	}

	public void setPwf(AdminDto pwfNum) {
		this.pwf = pwfNum;
	}


}
