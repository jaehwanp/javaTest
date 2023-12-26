package com.bit.lms.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.AssignDao;

//과제목록 컨트롤러
@WebServlet("/teacher/subject/list.lms")
public class AssignListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			AssignDao dao = new AssignDao();
			req.setAttribute("assignList", dao.assignList());

			RequestDispatcher rd = req.getRequestDispatcher("/teacher/subject/list.jsp");
			rd.forward(req, resp);
	}
}
