package com.bit.lms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.lms.model.dao.UserDao;
import com.bit.lms.model.dto.AdminDto;
import com.bit.lms.model.dto.UserDto;

@WebServlet("/join/signupInfo.lms")
public class UserSignupInfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id 	 	= req.getParameter("id");																//아이디
		String name  	= req.getParameter("name");																//이름
		String pw1	 	= req.getParameter("pw1");																//비밀번호1
		String pw2	 	= req.getParameter("pw2");																//비밀번호2
		String cp	 	= req.getParameter("cp1")+"-"+req.getParameter("cp2")+"-"+req.getParameter("cp3");		//핸드폰번호
		String email 	= req.getParameter("email1")+"@"+req.getParameter("email2");							//이메일
		int    sex	 	= Integer.parseInt(req.getParameter("sex"));											//성별
		String pwA	 	= req.getParameter("pwA");																//비밀번호찾기 답변
		int	   joinPath	= Integer.parseInt(req.getParameter("joinPath"));										//가입경로
		int	   pwfno	= Integer.parseInt(req.getParameter("pwfno"));											//비밀번호찾기질문번호
		int	   subno	= Integer.parseInt(req.getParameter("subno"));											//강좌번호
		String confirmCode = req.getParameter("confirmCode");													//강사확인코드

		int result=0;
		UserDao dao=new UserDao();
		
		//수강생 회원가입
		if(confirmCode == null || confirmCode.equals("")){
			//사용자DTO
			UserDto ud=new UserDto();
			ud.setId(id);
			ud.setName(name);
			ud.setPw1(pw1);
			ud.setPw2(pw2);
			ud.setCp(cp);
			ud.setEmail(email);
			ud.setSex(sex);
			ud.setPwA(pwA);
			ud.setJoinPath(joinPath);
			ud.setPwfno(pwfno);
			ud.setSubject(subno);
			
			
			result = dao.joinUs(ud);
		}else{//강사 회원가입
			//강사DTO
			AdminDto ad = new AdminDto();
			ad.setId(id);															//아이디
			ad.setName(name);														//이름
			ad.setPw1(pw1);															//비밀번호1
			ad.setPw2(pw2);															//비밀번호2
			ad.setHp(cp);															//핸드폰번호
			ad.setEmail(email);														//이메일
			ad.setSex(sex);															//성별
			ad.setConfirmNum(confirmCode); 											//확인코드
			ad.setPwA(pwA);															//비밀번호 답
			ad.setPwfno(pwfno);														//비밀번호찾기번호(질문을 가지고 오기 위한 번호)
			
			result = dao.joinAdmin(ad);
		}
		if(result==1){//회원가입 성공
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else{//회원가입 실패
			resp.sendRedirect(req.getContextPath()+"/login/login.jsp");
		}
		
	}
}
