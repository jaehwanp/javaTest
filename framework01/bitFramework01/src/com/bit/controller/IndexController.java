package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class IndexController implements Controller {

	public String execute(HttpServletRequest req) throws SQLException {
		req.setAttribute("msg", "환영합니다"); //값을 싣는다//컨트롤러 역할
//		String viewName="index.jsp";
		return "index";
	}
	
}
