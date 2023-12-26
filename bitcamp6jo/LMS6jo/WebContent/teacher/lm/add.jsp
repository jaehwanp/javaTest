<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../../common/header.jspf" %>
	<div id="content">
		<%@include file="./../../common/submenu.jspf" %>
		<div id="subContent">
		<div class="list_div">
			<h2>학습자료 등록</h2>
			<form action="<%=root %>/teacher/lm/add.lms" method="post" enctype="multipart/form-data">
			<table class="type12">
				<tr>
					<th>제목</th>
					<td style="text-align: left;"><input name="lmnm" type="text" placeholder="학습자료제목을 입력!"></td>
				</tr>
				<tr>
					<th class="file">파일첨부</th>
					<td>
						<input type="file" name="fileName"/>
					</td>
				</tr>
			</table>
			<input class="list_btn" type="submit" value="등록"/>
			</form>
		</div>

    </div>
<%@include file="./../../common/footer.jspf" %>