<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.lms.model.dto.*"%>
<!--<jsp:useBean id="qto1" scope="request" class="com.bit.lms.model.dto.QnaDto"></jsp:useBean>-->
<%@include file="./../common/header.jspf" %>
	<div id="content">
		<%@include file="./../common/submenu.jspf" %>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#nobtn').click(function(){
					alert('타인의 질문은 삭제가 불가능합니다');
					return false;
				});
			});
		</script>
		<div id="subContent">
		<%
			QnaDto qto=(QnaDto)request.getAttribute("qnaDetail");
		%>
		<form action="qnaQT_upd.lms">
			<table class="type11">
			<input type="hidden" name="idx" value="<%=qto.getNum()%>" />
				<tr>
					<th class="th1">작성자</th>
					<td style="text-align: left"><%=qto.getName1() %></td>
				</tr>
				<tr>
					<th class="th1">작성일자</th>
					<td style="text-align: left"><%=qto.getRegDate() %></td>
				</tr>
				<tr>
					<th class="th1">제목</th>
					<td style="text-align: left"><%=qto.getqSub() %></td>
				</tr>
				<tr>
					<th class="th1">내용</th>
					<td style="text-align: left"><%=qto.getqContent() %></td>
				</tr>
			</table>
			<center>
				<%if(String.valueOf(session.getAttribute("deptno")).equals("1")){%>
				
				<button type="submit" class="list_btn">답변</button>
				<button class="list_btn"><a href="#">삭제</a></button>
				<%}else { if(Integer.parseInt(String.valueOf(session.getAttribute("userno")))==qto.getUserno()){%>
				<button class="list_btn"><a href="qnaQT_delete.lms?idx=<%=qto.getNum()%>&userno=<%=qto.getUserno()%>">삭제</a></button>
				<%} else{%>
				<button id="nobtn" class="list_btn">삭제</button>
				<%}} %>
			</center>
			</form>
			<%if(qto.getaSub()!=null){%>
			<table class="type11">
				<tr>
					<th class="th1">답변일자</th>
					<td style="text-align: left"><%=qto.getUpdateDate() %></td>
				</tr>
				<tr>
					<th class="th1">제목</th>
					<td style="text-align: left"><%=qto.getaSub() %></td>
				</tr>
				<tr>
					<th class="th1">내용</th>
					<td style="text-align: left"><%=qto.getaContent() %></td>
				</tr>
			</table>
			<%}else{} %>
		</div>
    </div>
<%@include file="./../common/footer.jspf" %>