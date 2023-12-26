package com.bit.lms.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.AssignDao;
import com.bit.lms.model.dto.AssignDto;

@WebServlet("/teacher/subject/detail.lms")
public class AssignDetailController extends HttpServlet{

	//상세목록
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		int num = Integer.parseInt(idx);
		
		AssignDao dao = new AssignDao();
		req.setAttribute("assignDetail", dao.assignDetail(num));
		
		AssignDto bean = dao.assignDetail(num);
		
		req.setAttribute("fileName", bean.getFileName());
		
	
		//req.setAttribute("fileName", dao.getFileName(num));
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/subject/detail.jsp");
		rd.forward(req, resp);
	}
}
