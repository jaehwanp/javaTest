package com.bit.action;

import java.util.ArrayList;

import com.bit.model.Struts03Dao;
import com.bit.model.Struts03Dto;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {
	
	ArrayList<Struts03Dto> list;
	
	public ArrayList<Struts03Dto> getList() {
		return list;
	}
	
	@Override
	public String execute() throws Exception {
		Struts03Dao bean= new Struts03Dao();
		list=new ArrayList<Struts03Dto>();
		return this.SUCCESS;
	}

}
