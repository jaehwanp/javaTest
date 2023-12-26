package com.bit.lms.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.LearningMaterialsDao;
import com.bit.lms.model.dto.LearningMaterialsDto;

@WebServlet("/teacher/lm/list.lms")
public class LearningMaterialsListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LearningMaterialsDao dao = new LearningMaterialsDao();
		req.setAttribute("lmList", dao.list()); 
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/lm/list.jsp");
		rd.forward(req, resp);
	}
	
}
