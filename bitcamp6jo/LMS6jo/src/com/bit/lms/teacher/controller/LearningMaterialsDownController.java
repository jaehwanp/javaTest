package com.bit.lms.teacher.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/teacher/lm/down.lms")
public class LearningMaterialsDownController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String fileName = req.getParameter("fileName");
		//다운로드 받을 때 한글 처리
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		
		HttpSession session = req.getSession();
		
		String aId = (String)session.getAttribute("adminid");
		
		ServletContext context = getServletContext();
		//실제 파일이 저장되는 폴더
		String realFolder = context.getRealPath("/upload/teacher/"+aId+"/lm");
		System.out.println(realFolder);
		
		//파일경로/파일명
		String filePath = realFolder + "/" + fileName;
		
		//경로 설정
		//String filePath = "C:\\java\\git\\repository\\bitcamp6jo\\LMS6jo\\WebContent\\upload\\teacher\\"+aId+"\\lm\\"+fileName;	

        File file = new File(filePath); // 받은 파일명과 경로로 해당 파일 선언
        resp.setContentType("application/octet-stream"); // 파일 형태 지정

        //응답 헤더의 Content-Type을 세팅한다.
        resp.setHeader("Content-Disposition", "attachment;filename="+fileName);


        byte b[] = new byte[10 * 1024 * 1024];

        //10M까지 업로드가 가능하므로 크기를 이렇게 잡아주었음.
        if(file.isFile()){
                BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream outs = new BufferedOutputStream(resp.getOutputStream());

                try{
                    int read = 0;
                    while ((read = fin.read(b)) != -1){
                            outs.write(b,0,read);
                    }
                    outs.flush();
                    outs.close();
                    fin.close();
                }catch(Exception e){}
        }

		RequestDispatcher rd = req.getRequestDispatcher("/teacher/lm/list.lms");
		rd.forward(req, resp);
	}
	
}
