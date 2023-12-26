package com.bit.lms.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.NoticeDao;

//영업페이지 공지사항 목록 컨트롤러
@WebServlet("/notice/list.lms")
public class NoticeListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//doPost(req,resp);
		String keyword=req.getParameter("keyword");
		
		NoticeDao dao=new NoticeDao();
		req.setAttribute("salesList", dao.list(keyword)); 
		
		RequestDispatcher rd = req.getRequestDispatcher("/notice/notice_list.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}
	
}
