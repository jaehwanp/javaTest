package com.bit.lms.teacher.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.QnaDao;

@WebServlet("/teacher/qnaQT_delete.lms")
public class QnaADelController extends HttpServlet{

	//삭제
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("idx"));
		int userno=Integer.parseInt(req.getParameter("userno"));
		QnaDao dao=new QnaDao();
		dao.qnaADel(num, userno);
		
		resp.sendRedirect("qnaQT_list.lms");
	}
	
	//삭제
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
