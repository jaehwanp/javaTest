package com.bit.lms.model.dto;

public class AdminDto {
	
	//관리자
	private int 	num;		//관리자번호
	private String 	id;			//관리자아이디
	private String 	name;		//관리자이름 
	private String 	pw1;		//패스워드
	private String 	pw2;		//패스워드확인
	private String  hp;			//핸드폰번호
	private String 	email;		//이메일
	private int 	sex;		//성별
	private int		state;		//상태값(0:가입, 1:회원탈퇴대기)
	private String	confirmNum;	//확인번호
	private String	pwA;		//비밀번호답
	private int 	deptno;			//부서번호(1:강사 2:영업 3:행정)
	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	//직급(관리자부서)
	private DeptDto	dept;		//직급번호(dept.num)		
	//비밀번호찾기
	//private PwfDto	pwf;	//비밀번호찾기번호(pwf.num)
	private int		pwfno;
	
	//생성자
	public AdminDto() {
		
	}

	//getter,setter
	public int getNum() {
		return num;
	}

	public int getPwfno() {
		return pwfno;
	}

	public void setPwfno(int pwfno) {
		this.pwfno = pwfno;
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

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getConfirmNum() {
		return confirmNum;
	}

	public void setConfirmNum(String confirmNum) {
		this.confirmNum = confirmNum;
	}

	public String getPwA() {
		return pwA;
	}

	public void setPwA(String pwA) {
		this.pwA = pwA;
	}

	public DeptDto getDept() {
		return dept;
	}

	public void setDept(DeptDto dept) {
		this.dept = dept;
	}
	
}
