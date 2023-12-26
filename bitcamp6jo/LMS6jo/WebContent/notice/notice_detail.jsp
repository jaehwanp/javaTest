<%@page import="com.bit.lms.model.dto.NoticeDto"%>
<%@page import="com.bit.lms.model.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


</script>
</head>
<body>
<%@include file="./../../common/header.jspf" %>
		<%@include file="./../../common/submenu.jspf" %>
<div id="notice-main">
<h2 style="margin-left: 800px;">공지사항</h2>
<form method="get" action="<%=root %>/notice/add.lms" name="form">
<%
String param=request.getParameter("nno");
int nno=Integer.parseInt(param);
NoticeDao dao = new NoticeDao();
NoticeDto dto=dao.detailOne(nno);

%>

	<table id="salesList" style="width: 1200px; margin-left: 285px;">
					<tr  style="text-align: center; background-color: #eeeeee; height: 34px;">
						<th style="width: 110px;">제 목</th>
						<th colspan="3" style="width: 1090px; background-color: white; border: 1px solid #eeeeee; text-align: left"><span style=" width: 900px; height: 23px;">&nbsp;<%=dto.getSubject() %></span></th>
					</tr>
					<tr  style="text-align: center; background-color: #eeeeee; height: 34px;">
						<th style="width: 110px;">작성자</th>
						<th style="background-color: white; border: 1px solid #eeeeee; text-align: left"><span style="height: 23px;">&nbsp;<%=session.getAttribute("name") %></span></th>
						<th style="width: 110px;">작성일</th>
						<th style="background-color: white; border: 1px solid #eeeeee; text-align: left"><span style="height: 23px;">&nbsp;<%=dto.getRegdate() %></span></th>
					</tr>	
					<tr>
						<td colspan="4" style="border: 1px solid #eeeeee; height: 340px; vertical-align: top">
							<span>&nbsp;<%=dto.getContent()%></span>
						</td>
					</tr>
	</table>
	
	<br>
	<div style="margin-left: 720px;">
	<button style="border: 1px solid #3498DB; background-color: #3498DB;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;"><a style="color: white; text-decoration: none;" href="/LMS6jo/notice/list.lms">목 록</a></button>
	<button style="border: 1px solid #3498DB; background-color: #3498DB;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;"><a style="color: white; text-decoration: none;" href="notice_edit.jsp?nno=<%=dto.getNum() %>">수 정</a></button>
	<button style="border: 1px solid #3498DB; background-color: #3498DB;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;"><a style="color: white; text-decoration: none;" href="/LMS6jo/notice/listdelete.lms?nno=<%=dto.getNum()%>">삭 제</a></button>
	</div>
	<script>
	        	function checkOk(){
	        		document.form.submit();
	        	}
	        </script>
</form>
	</div>
<%@include file="./../../common/footer.jspf" %>
</body>
</html>