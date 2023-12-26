package com.bit.lms.teacher.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;
import javax.websocket.Session;

import com.bit.lms.model.dao.QnaDao;

@WebServlet("/teacher/qnaQT_add.lms")
public class QnaAInsertController extends HttpServlet{

	//입력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		System.out.println("userno" + session.getAttribute("userno"));
//		if(session.getAttribute("userno")==null){
//			resp.sendRedirect(req.getContextPath()+"/login/login.lms");
//		}else{
//			RequestDispatcher rd = req.getRequestDispatcher("/teacher/qnaQT_add.jsp");
//			rd.forward(req, resp);			
//		}
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/qnaQT_add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dd");
		req.setCharacterEncoding("utf-8");
		System.out.println("dd");
		String sub=req.getParameter("qsub");
		System.out.println(sub);
		String content=req.getParameter("qcontent");
		System.out.println(content);
		int userno=Integer.parseInt(req.getParameter("userno"));
		System.out.println(userno);
		
		String regdates=req.getParameter("regdate");
		java.sql.Date regdate=java.sql.Date.valueOf(regdates);
		
		
		QnaDao dao=new QnaDao();
		dao.qnaAInsert(sub, content, regdate, userno);
		
		resp.sendRedirect("qnaQT_list.lms");
	}
	
}
