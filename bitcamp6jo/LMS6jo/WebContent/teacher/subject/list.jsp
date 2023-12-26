<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.lms.model.dto.AssignDto,java.util.ArrayList"%>
    
<%@include file="./../../common/header.jspf" %>
	<div id="content">
		<%@include file="./../../common/submenu.jspf" %>
		<div id="subContent">
		<div class="list_div">
			<table class="type12">
				<thead>
					<tr>
						<th>번호</th>
						<th>과제명</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>파일여부</th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<AssignDto> list = null;
					list = (ArrayList<AssignDto>)request.getAttribute("assignList");
					if(list != null){
						for(AssignDto bean : list){
				%>
					<tr>
						<td><%=bean.getNum() %></td>
						<td><a href="<%=root %>/teacher/subject/detail.lms?idx=<%=bean.getNum()%>"><%=bean.getName() %></a></td>
						<td><%=bean.getUname() %></td>
						<td><%=bean.getRegdate() %></td>
						<td>
						<% if(bean.getFileName()!=null){%>
							<a href="#">
								<i class="fa fa-file-text-o"></i>
							</a>
						<% }%>
						</td>
					</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
		</div>
    </div>
    </div>
<%@include file="./../../common/footer.jspf" %>