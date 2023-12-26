package com.bit.struts.model.entity;

import java.sql.Date;

public class Struts06Vo {
	private int num;
	private String sub,name,content;
	private Date nalja;
	
	public Struts06Vo() {
		// TODO Auto-generated constructor stub
	}

	public Struts06Vo(int num, String name, String sub, Date nalja) {
		this.num=num;
		this.name=name;
		this.sub=sub;
		this.nalja=nalja;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
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
	
	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "Struts06Vo [num=" + num + ", sub=" + sub + ", name=" + name
				+ ", content=" + content + ", nalja=" + nalja + "]";
	}

	
}
