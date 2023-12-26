package com.bit.lms.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.QnaDao;

@WebServlet("/teacher/qnaQT_detail.lms")
public class QnaDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		int num=Integer.parseInt(param);
		System.out.println(num);
		QnaDao dao=new QnaDao();
		req.setAttribute("qnaDetail", dao.qnaDetail(num));
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/qnaQT_detail.jsp");
		rd.forward(req, resp);
	}
}