<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.bit.lms.model.dto.*"%>
<%@include file="./../common/header.jspf" %>
	<div id="content">
		<%@include file="./../common/submenu.jspf" %>
		<div id="subContent">
		<div class="list_div">
			<table class="type13">
				<thead>
					<tr>
						<th>번호</th>
						<th>과정명</th>
						<th>질문</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>답변일자</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<QnaDto> list=(ArrayList<QnaDto>)request.getAttribute("qnalist");
					for(QnaDto qto : list){
				%>
					<tr>
						<td><%=qto.getNum() %></td>
						<td><%=qto.getName2() %></td>
						<td><a href="qnaQT_detail.lms?idx=<%=qto.getNum()%>"><%=qto.getqSub() %></a></td>
						<td><%=qto.getName1() %></td>
						<td><%=qto.getRegDate() %></td>
						<td><%if(qto.getaSub()!=null){%><%=qto.getUpdateDate() %><%}else{} %></td>
						<td><%if(qto.getaSub()!=null){%>답변완료<%}else{} %></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<%
			if(session.getAttribute("userno") != null){%>
			<a href="qnaQT_add.lms">입력</a>
			<%}else{} %>
		</div>
		</div>
    </div>
<%@include file="./../common/footer.jspf" %>