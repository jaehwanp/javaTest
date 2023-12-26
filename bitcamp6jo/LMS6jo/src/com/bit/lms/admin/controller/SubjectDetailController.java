package com.bit.lms.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.SubjectDao;

@WebServlet("/admin/subA_Detail.lms")
public class SubjectDetailController extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String idx = req.getParameter("idx");
      int num = Integer.parseInt(idx);
      
      SubjectDao dao = new SubjectDao();
      req.setAttribute("subDetail", dao.subjectDetail(num));
      
      RequestDispatcher rd = req.getRequestDispatcher("/admin/subA_detail.jsp");
      rd.forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      String num=req.getParameter("idx");
      int subno=Integer.parseInt(num);
      System.out.println(subno);
      SubjectDao dao=new SubjectDao();
      dao.subjectDelete(subno);
      resp.sendRedirect("/LMS6jo/admin/subA_list.lms");
   }
}