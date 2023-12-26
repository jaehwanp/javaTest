<%@page import="com.bit.lms.model.dto.NoticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function add(){
	location.href=('notice_add.jsp');
}
</script>
</head>
<body>
<%@include file="./../../common/header.jspf" %>
		<%@include file="./../../common/submenu.jspf" %>
<div id="notice-main">
<h2 style="margin-left: 800px;">공지사항</h2>
	<div style="margin-left: 1250px;">
	<form action="<%=root %>/notice/list.lms" method="get">
	<input name="keyword" type="text" placeholder="검색어를 입력하세요" style="height: 25px;">
	<input type="submit" value="검색" style="border: 1px solid #7F7F7F; background-color: #7F7F7F;color: white;border-radius: 5px; width: 55px; height: 32px; font-weight: bold;">
	</form>
	</div>
	<table id="salesList" style="width: 1200px; margin-left: 285px;">
					<tr  style="text-align: center; background-color: #eeeeee; height: 34px;">
						<th>글번호</th>
						<th style="width: 900px;">제목</th>
						<th>작성자</th>
						<th>작성일자</th>
					</tr>
					<%
						ArrayList<NoticeDto> list=(ArrayList<NoticeDto>)request.getAttribute("salesList");
						
						for(int i=0; i<list.size(); i++){
							NoticeDto dto=list.get(i);
							if(dto.getTopstate()==1){
					%>
					<tr  style="border-bottom : 1px solid darkgray; text-align: center; height: 30px; background-color: #F2C4C4">
						<td><%=dto.getNum() %></td>
						<td><a style="color: black" href="notice_detail.jsp?nno=<%=dto.getNum() %>"><%=dto.getSubject() %></a></td>
						<td><%=session.getAttribute("name") %></td>
						<td><%=dto.getRegdate() %></td>
					</tr>
					<%}else{%>
					<tr  style="border-bottom : 1px solid darkgray; text-align: center; height: 30px;">
						<td><%=dto.getNum() %></td>
						<td><a style="color: black" href=notice_detail.jsp?nno=<%=dto.getNum() %>><%=dto.getSubject() %></a></td>
						<td><%=session.getAttribute("name") %></td>
						<td><%=dto.getRegdate() %></td>
					</tr>
					<%} 
					}
					%>
					
	</table>
	<br>

	<div style="margin-left: 1400px;">
	<input type="submit" value="글쓰기" style="border: 1px solid #3498DB; background-color: #3498DB;color: white;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;" onclick="add()">
	</div>
<%@include file="./../../common/footer.jspf" %>
</body>
</html>
