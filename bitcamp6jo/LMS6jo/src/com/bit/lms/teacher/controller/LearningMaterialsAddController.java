package com.bit.lms.teacher.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.lms.model.dao.LearningMaterialsDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/teacher/lm/add.lms")
public class LearningMaterialsAddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/teacher/lm/add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int maxsize = 1024*1024*10;//10mb
		//String path = "C:\\Users\\USER\\workspace3\\LMS6jo\\WebContent\\upload\\teacher";
		
		HttpSession session = req.getSession();
		
		String aId = (String)session.getAttribute("adminid");
		
		ServletContext context = getServletContext();
		
		//실제 파일이 저장되는 폴더
		String path = context.getRealPath("/upload/teacher/"+aId+"/lm");
		//String path = "C:\\java\\git\\repository\\bitcamp6jo\\LMS6jo\\WebContent\\upload\\teacher\\"+aId+"\\lm";
		
		File folder = new File(path);
		
		//폴더가 없을 때 생성해준다.
		if(!folder.exists()){
			folder.mkdirs();
		}
		
		//파일의 이름이 같을 때 조치를 취한다.(cos.jar가 있어야 한다.)
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
	
		//req, server업로드 위치, 용량, 엔코딩타입
		MultipartRequest mr = new MultipartRequest(req, path, maxsize, "utf-8", dfrp);
		
		String origin 	= mr.getOriginalFileName("fileName");	//파일명
		String lmnm		= mr.getParameter("lmnm");				//학습자료제목
		String rename 	= mr.getFilesystemName("fileName");		//중복이 되면서 바뀐 이름
		
		req.setCharacterEncoding("utf-8");

		req.setAttribute("fname", rename);
		
		//관리자번호(강사번호)를 가지고온다.
		LearningMaterialsDao dao = new LearningMaterialsDao();
		int adno = dao.getAdno(aId);
		
		//학습자료 업로드 및 입력
		int result = dao.addList(lmnm, origin, path, adno);
		
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		if(result > 0){
//			out.println("<script>alert('업로드 성공')</script>");
//			out.close();
			resp.sendRedirect("/LMS6jo/teacher/lm/list.lms");
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/teacher/lm/add.jsp");
			rd.forward(req, resp);
		}

	
	}
	
}
