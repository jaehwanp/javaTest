<%@page import="java.sql.Date"%>
<%@page import="com.bit.lms.model.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/* controller로 옮겨서 이제 지워도 되는 파일입니다. */
		request.setCharacterEncoding("UTF-8");
		
		
		String num=request.getParameter("idx");
		int subno=Integer.parseInt(num);
		
		SubjectDao dao=new SubjectDao();
		dao.subjectDelete(subno);
		response.sendRedirect("/LMS6jo/admin/subA_list.lms");
	%>
</body>
</html>