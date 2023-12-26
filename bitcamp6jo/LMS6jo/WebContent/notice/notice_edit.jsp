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
<%
String param=request.getParameter("nno");
int nno=Integer.parseInt(param);
NoticeDao dao = new NoticeDao();
NoticeDto dto=dao.detailOne(nno);
int topstate=dto.getTopstate();
System.out.println(topstate);
%>
<form method="post" action="<%=root %>/notice/listedit.lms">
	<input type="hidden" name="num" value="<%=dto.getNum()%>">

	<table id="salesList" style="width: 1200px; margin-left: 285px;">
					<tr  style="text-align: center; background-color: #eeeeee; height: 34px;">
						<th style="width: 110px;">제 목</th>
						<th  style="width: 890px; background-color: white; border: 1px solid #eeeeee; text-align: left"><input name="sub" type="text" value="<%=dto.getSubject() %>" style="width: 900px; height: 25px; border-color: #eeeeee"></th>
						<%if(topstate==1){
							%>
						<th style="background-color: #BEBEBE;"><input id="topstate" name="topstate" type="checkbox" value="1" checked="checked" style="width: 23px; height: 23px;"></th>
						<%}else{ %>
						<th style="background-color: #BEBEBE;"><input id="topstate" name="topstate" type="checkbox" value="1"  style="width: 23px; height: 23px;"></th>
						<%} %>
						<th style="background-color: #BEBEBE; text-align: left;"><span>상단 노출</span></th>
					</tr>
					</table>
					<table style="width: 1200px; margin-left: 285px; margin-top: 0px;">
					<tr  style="text-align: center; background-color: #eeeeee; height: 34px;">
						<th style="width: 110px;">작성자</th>
						<th style="width: 490px; background-color: white; border: 1px solid #eeeeee; text-align: left"><span style="height: 25px;">&nbsp;<%=session.getAttribute("name") %></span></th>
						<th style="width: 110px;">작성일</th>
						<th style="background-color: white; border: 1px solid #eeeeee; text-align: left"><span style="height: 25px;">&nbsp;<%=dto.getRegdate() %></span></th>
					</tr>	
						<td colspan="4" style="border: 1px solid #eeeeee; height: 340px; vertical-align: top">
							<textarea name="content" cols="169" rows="22" style="resize: none"><%=dto.getContent()%></textarea>
						</td>
					</tr>
	</table>
	
	<br>
	<div style="margin-left: 760px;">
	<input type="submit" value="수 정" style="border: 1px solid #3498DB; background-color: #3498DB;color: white;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;">
	<button style="border: 1px solid #3498DB; background-color: #3498DB;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;"><a href="/LMS6jo/notice/list.lms" style="color: white; text-decoration: none;">목 록</a></button>
	</div>

</form>
	</div>
<%@include file="./../../common/footer.jspf" %>
</body>
</html>