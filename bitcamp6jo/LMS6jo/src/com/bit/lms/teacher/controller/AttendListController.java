package com.bit.lms.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.AttendDao;

//출결관리목록 컨트롤러
@WebServlet("/teacher/attend/list.lms")
public class AttendListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("wqw");
		AttendDao dao=new AttendDao();
		req.setAttribute("attlist", dao.attendList("07"));
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/attend/list.jsp");
		rd.forward(req, resp);
	}
	
}
