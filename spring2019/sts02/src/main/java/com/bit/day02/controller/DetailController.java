package com.bit.day02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.day02.model.Day02Dao;

public class DetailController implements Controller {
	private Day02Dao dao;
	private String viewName;
	
	public void setDao(Day02Dao dao) {
		this.dao = dao;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num=Integer.parseInt(request.getParameter("idx"));
		ModelAndView mav =new ModelAndView();
		mav.addObject("bean", dao.selectOne(num));
		mav.setViewName(viewName);
		return mav;
	}

}
