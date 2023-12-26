package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.dao.UserDao;

@WebServlet("/login/login.lms")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		UserDao dao=new UserDao();
		int result=dao.login(id, pw);
		String name=dao.loginname(id);
		String userno=dao.loginno(id)+"";
		
		
		HttpSession session=req.getSession();
		
		if(result==1){
			session.setAttribute("userid", id);
			session.setAttribute("name", name);
			session.setAttribute("userno", userno);
			resp.sendRedirect("/LMS6jo/index.jsp?param=success");
		}else if(result==0){
			resp.sendRedirect("/LMS6jo/login/login.jsp?param=fail");
		}
		
	}
}
