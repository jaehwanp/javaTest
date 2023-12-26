package com.bit.lms.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.NoticeDao;

@WebServlet("/notice/add.lms")

public class NoticeAddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doPost(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String sub=req.getParameter("sub");
		String content=req.getParameter("content");
		String top=req.getParameter("topstate");
		if(top==null)top="0";
		int topstate=Integer.parseInt(top);
		
		if(sub!=null && content!=null){
		NoticeDao dao=new NoticeDao();
		dao.addList(sub, content, topstate);
		}
		resp.sendRedirect("/LMS6jo/notice/list.lms");
		
	}
}
