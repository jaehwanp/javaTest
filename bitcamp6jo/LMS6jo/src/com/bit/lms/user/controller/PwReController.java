package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.UserDao;

@WebServlet("/login/pwRe.lms")
public class PwReController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pw1=req.getParameter("pw1");
		String pw2=req.getParameter("pw2");
		String id=req.getParameter("id");
		
		
		UserDao dao=new UserDao();
		int result=dao.updPw(pw1, pw2, id);
		if(result==1){
			resp.sendRedirect("/LMS6jo/login/login.jsp");
		}else{
			resp.sendRedirect("/LMS6jo/login/pwf.jsp?param=fail");
		}
	}
}
