package com.bit.lms.teacher.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.QnaDao;

@WebServlet("/teacher/qnaQT_upd.lms")
public class QnaAUpdController extends HttpServlet{

	//답변 창으로
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		int num=Integer.parseInt(param);
		System.out.println("qnano:"+num);
		QnaDao dao=new QnaDao();
		req.setAttribute("qnaUpd", dao.qnaDetail(num));
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/qnaQT_upd.jsp");
		rd.forward(req, resp);
	}
	
	//답변
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		System.out.println("post 들어옴");
		String param=req.getParameter("idx");
		System.out.println("1");
		int qnano=Integer.parseInt(param);
		System.out.println("2");
		String asub=req.getParameter("asub");
		System.out.println("3");
		String acontent=req.getParameter("acontent");
		System.out.println("4");
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date updatedate = new java.sql.Date(utilDate.getTime());
		
		
		System.out.println("qnano:"+qnano);
		System.out.println("asub:"+asub);
		System.out.println("acontent:"+acontent);
		System.out.println("updatedate:"+updatedate);
		System.out.println("5");
		QnaDao dao=new QnaDao();
		System.out.println("6");
		dao.qnaAUpd(asub, acontent, updatedate, qnano);
		
		System.out.println("qna업데이트");
		
		resp.sendRedirect("qnaQT_list.lms");
	}
	
}
