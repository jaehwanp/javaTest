package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.UserDao;

@WebServlet("/login/pwf.lms")
public class PwfController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String pwfno=req.getParameter("pwfno");
		int pwq=Integer.parseInt(pwfno);
		String pwa=req.getParameter("pwa");
		
		UserDao dao=new UserDao();
		int result=dao.findPw(id, pwq, pwa);
		
		if(result==1){
			resp.sendRedirect("/LMS6jo/login/pwRe.jsp?param="+id);
		}else{
			resp.sendRedirect("/LMS6jo/login/pwf.jsp?param=fail");
		}
	}
}
