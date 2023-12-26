<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/header.jspf" %>
	<div id="content">
	<%@include file="./../../common/submenu.jspf" %>
		<div id="subContent">
		<div class="list_div">
		<div id="lectureDetail">
			<h2>입력페이지</h2>
			<form action="<%=root %>/admin/subA_add.lms" method="post">
			<table class="detail_type">
			<%
			
			%>
				<tr>
					<th>강좌명</th>
					<td colspan=7><input type="text" name="subnm"></td>
				</tr>
				<tr>
					<th>강사명</th>
					<td colspan="7"><input type="text" name="subTeacher"></td>
				</tr>
				<tr>
					<th>제한인원</th>
					<td><input type="text" name="limitno"></td>
					<td>명</td>
					<td colspan=5></td>
				</tr>
				<tr>
					<th>수강마감일</th>
					<td> <select name="limit_year">
		                <option value="0">년</option>
		                <%for(int year=2015 ;year<2025; year++){ %>
		                	 <option value="<%=year%>"><%=year%>년</option>
		                <%} %>
		            </select></td>
		            <td> <select name="limit_month">
		            	<option value="0">월</option>
		            	<% 
		            	for(int month=1; month<13; month++){ %>
		            		<option value="<%=month%>"><%=month%>월</option>
		                <%} %>
		         	</select></td>
		         	<td> <select name="limit_day">
		            	<option value="0">일</option>
		            	<% 
		            	for(int day=1; day<32; day++){ %>
		            		<option value="<%=day%>"><%=day%>일</option>
		                <%} %>
		         	</select></td>
		         	<td colspan=4></td>
				<tr>
					<th>교육기간</th>
					<td> <select name="start_year">
		                <option value="0">년</option>
		                <%for(int year=2015 ;year<2025; year++){ %>
		                	 <option value="<%=year%>"><%=year%>년</option>
		                <%} %>
		            </select></td>
		            <td> <select name="start_month">
		            	<option value="0">월</option>
		            	<% 
		            	for(int month=1; month<13; month++){ %>
		            		<option value="<%=month%>"><%=month%>월</option>
		                <%} %>
		         	</select></td>
		         	<td> <select name="start_day">
		            	<option value="0">일</option>
		            	<% 
		            	for(int day=1; day<32; day++){ %>
		            		<option value="<%=day%>"><%=day%>일</option>
		                <%} %>
		         	</select></td>
		         	<td> ~ </td>
		         	<td> <select name="end_year">
		                <option value="0">년</option>
		                <%for(int year=2015 ;year<2025; year++){ %>
		                	 <option value="<%=year%>"><%=year%>년</option>
		                <%} %>
		            </select></td>
		            <td> <select name="end_month">
		            	<option value="0">월</option>
		            	<% 
		            	for(int month=1; month<13; month++){ %>
		            		<option value="<%=month%>"><%=month%>월</option>
		                <%} %>
		         	</select></td>
		         	<td> <select name="end_day">
		            	<option value="0">일</option>
		            	<% 
		            	for(int day=1; day<32; day++){ %>
		            		<option value="<%=day%>"><%=day%>일</option>
		                <%} %>
		         	</select></td>
				</tr>
				<tr>
					<td colspan=8><textarea name="subcontent" rows="5" cols="120"></textarea></td>
			<tr>
					<td colspan="8">
						<input class="list_btn" type="submit" value="입 력">
						<input class="list_btn" type="reset" value="취 소">
					</td>
				</tr>
		</table>
		</form>
			</div>
			</div>
    	</div>
    </div>
<%@include file="./../common/footer.jspf" %>
