package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.dao.UserDao;

@WebServlet("/login/adminlogin.lms")
public class AdminLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		UserDao dao=new UserDao();
		int result=dao.adminlogin(id, pw);
		String name=dao.loginAdminname(id);
		String deptno=dao.deptNo(id)+"";
		String adno=dao.loginAdmino(id)+"";
		
		
		HttpSession session=req.getSession();
		
		if(result==1){
			session.setAttribute("adminid", id);
			session.setAttribute("name", name);
			session.setAttribute("deptno", deptno);
			session.setAttribute("adno", adno);
			System.out.println("adminid:"+session.getAttribute("adminid")+"name:"+session.getAttribute("name")+
					"deptno:"+session.getAttribute("deptno")+"adno:"+session.getAttribute("adno"));
			resp.sendRedirect("/LMS6jo/index.jsp?param=success");
			System.out.println(deptno);
		}else if(result==0){
			resp.sendRedirect("/LMS6jo/login/adminlogin.jsp?param=fail");
		}
		
	}
}
