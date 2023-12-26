package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.AttendDao;
import com.bit.lms.model.dao.QnaDao;

public class UserQnaListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QnaDao dao=new QnaDao();
		req.setAttribute("qnalist", dao.qnaList());
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/qnaQT_list.jsp");
		rd.forward(req, resp);
	}
	
}
