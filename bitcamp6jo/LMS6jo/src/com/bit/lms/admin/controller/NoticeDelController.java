package com.bit.lms.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.NoticeDao;

@WebServlet("/notice/listdelete.lms")
public class NoticeDelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String param=req.getParameter("nno");
		int num=Integer.parseInt(param);
		NoticeDao dao=new NoticeDao();
		dao.deleteOne(num);
		
		resp.sendRedirect("/LMS6jo/notice/list.lms");
	}
	
}
