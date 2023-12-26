package com.bit.lms.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.NoticeDao;

@WebServlet("/notice/listedit.lms")
public class NoticeUpdController extends HttpServlet{


	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String param=req.getParameter("num");
		int num=Integer.parseInt(param);
		String sub =req.getParameter("sub");
		String content =req.getParameter("content");
		String top=req.getParameter("topstate");
		if(top==null)top="0";
		int topstate=Integer.parseInt(top);
		
		NoticeDao dao=new NoticeDao();
		dao.editOne(num, sub, content, topstate);
		
		resp.sendRedirect("/LMS6jo/notice/notice_detail.jsp?nno="+num);
		
	}
}
