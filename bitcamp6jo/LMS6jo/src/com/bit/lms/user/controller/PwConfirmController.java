package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.UserDao;

@WebServlet("/join/confirmId.bit")
public class PwConfirmController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		
		UserDao dao=new UserDao();
		int result=dao.confirmId(id);
		RequestDispatcher rd=req.getRequestDispatcher("../join/confirmId.jsp?result="+result+"&id="+id);
		rd.forward(req, resp);
	}
}
