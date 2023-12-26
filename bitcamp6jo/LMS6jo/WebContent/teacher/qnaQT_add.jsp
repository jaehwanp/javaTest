<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.SimpleDateFormat,java.util.Date"%>
<%@include file="./../common/header.jspf" %>
	<div id="content">
		<%@include file="./../common/submenu.jspf" %>
		<div id="subContent">
			<h1>답변등록</h1>
			<form action="qnaQT_add.lms" method="POST">
			<table class="type12">
				<tr>
					<th class="th1">작성자</th>
					<td style="text-align: left"><input type="hidden" name="userno" value="<%=session.getAttribute("userno")%>"/><%=session.getAttribute("name") %></td>
				</tr>
				<tr>
				<%
				System.out.println(session.getAttribute("userno"));
				SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
				Date time = new Date();
				
				String currentTime=format1.format(time);
				%>
					<th class="th1">작성일자</th>
					<td style="text-align: left"><input type="hidden" name="regdate" value="<%=currentTime %>"/><%=currentTime %></td>
				</tr>
				<tr>
					<th class="th1">제목</th>
					<td class="updTd" style="text-align: left"><input class="updTd" type="text" style="width:100%; border:0;" name="qsub"/></td>
				</tr>
				<tr>
					<th class="th1">내용</th>
					<td class="updTd" style="text-align: left"><textarea cols="130" rows="10" name="qcontent"></textarea></td>
				</tr>
			</table>
			<center>
				<button type="submit" class="list_btn"/>답변등록</button>
				<button type="reset" class="list_btn">답변취소</button>
			</center>		
			</form>
		</div>
    </div>
<%@include file="./../common/footer.jspf" %>