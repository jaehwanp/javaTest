package com.bit.lms.model.dto;

import java.sql.Date;

public class LearningMaterialsDto {
	
	//학습자료
	private int 	num;		//학습자료번호
	private String 	name;		//학습자료이름
	private Date	regdate;	//학습자료등록일자
	private String	fileName;	//파일명
	private String 	filePath;	//파일경로
	
	//관리자 객체
	//private AdminDto admin;		//관리자번호(admin.num)
	private int adno;			//관리자번호
	private String aname;		//강사이름
	
	//생성자
	public LearningMaterialsDto() {
		
	}

	//getter,setter
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getAdno() {
		return adno;
	}

	public void setAdno(int adno) {
		this.adno = adno;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	
	
	
	
}
