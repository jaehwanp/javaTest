package com.bit.lms.model.dto;

import java.sql.Date;

public class SubjectDto {
	
	//강좌
	private int 		num;			// 강좌번호
	private String		name;			// 강좌명
	private String		content;		// 강좌설명
	private int			limitNum;		// 강좌제한인원
	private String		limitEnd;		// 수강마감일
	private String		eduStart;		// 개강일자
	private String		eduEnd;			// 종강일자
	private Date		regdate;		// 강좌작성일자
	private int			classNum;		// 반번호
	private String		className;		// 반명
	private String		adminName;		// 강사 이름
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	//관리자
	private AdminDto	admin;			//관리자번호(admin.num)

	//getter, setter
	public SubjectDto() {
		
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

	public String getLimitEnd() {
		return limitEnd;
	}

	public void setLimitEnd(String limitEnd) {
		this.limitEnd = limitEnd;
	}

	public String getEduStart() {
		return eduStart;
	}

	public void setEduStart(String eduStart) {
		this.eduStart = eduStart;
	}

	public String getEduEnd() {
		return eduEnd;
	}

	public void setEduEnd(String eduEnd) {
		this.eduEnd = eduEnd;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public AdminDto getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDto admin) {
		this.admin = admin;
	}
	
	
	
	
}
