<%@page import="com.bit.lms.model.dto.LearningMaterialsDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../../common/header.jspf" %>
	<div id="content">
		<%@include file="./../../common/submenu.jspf" %>
		<div id="subContent">
		<div class="list_div">
			<table class="type12">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>파일여부</th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<LearningMaterialsDto> list = null;
					list = (ArrayList<LearningMaterialsDto>)request.getAttribute("lmList");
					if(list != null){
						
						
						for(LearningMaterialsDto bean : list){
				%>
							<tr>						
								<td><input type="hidden" name="name" value="<%=bean.getName() %>"/><%=bean.getNum() %></td>
								<td><%=bean.getName() %></td>
								<td><%=bean.getAname() %></td>
								<td><%=bean.getRegdate() %></td>
								<td>
								<% if(bean.getFileName()!=null){%>
									<a href="<%=root %>/teacher/lm/down.lms?fileName=<%=bean.getFileName()%>">

										<i class="fa fa-file-text-o"></i>
									</a>
								<%}%> 
								</td>
							</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
			<%if(session.getAttribute("adminid") != null){ %>
				<a class="list_btn" href="<%=root%>/teacher/lm/add.lms">업로드</a>
			<%}%>

		</div>
    </div>
<%@include file="./../../common/footer.jspf" %>
