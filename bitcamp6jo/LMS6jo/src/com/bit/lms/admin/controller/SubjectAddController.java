package com.bit.lms.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.SubjectDao;

@WebServlet("/admin/subA_add.lms")
public class SubjectAddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/LMS6jo/admin/subA_add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String subnm=req.getParameter("subnm");
		String content=req.getParameter("subcontent");
		String limitno = req.getParameter("limitno");
		int limitNum=Integer.parseInt(limitno);
		String limitEnd = req.getParameter("limit_year")+"-"+req.getParameter("limit_month")+"-"+req.getParameter("limit_day");
		String eduStart = req.getParameter("start_year")+"-"+req.getParameter("start_month")+"-"+req.getParameter("start_day");
		String eduEnd = req.getParameter("end_year")+"-"+req.getParameter("end_month")+"-"+req.getParameter("end_day");
	
		
		SubjectDao dao=new SubjectDao();
		dao.subjectAdd(subnm, content, limitNum, limitEnd, eduStart, eduEnd); 
		resp.sendRedirect("/LMS6jo/admin/subA_list.lms");
		
	}
}
