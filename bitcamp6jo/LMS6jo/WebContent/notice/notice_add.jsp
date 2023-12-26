<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check() {
	if(document.getElementById("sub").value.trim()==""){
		alert("제목을 입력해주세요");
		return false;
	}
	if(document.getElementById("content").value.trim()==""){
		alert("내용을 입력해주세요");
		return false;
	}
	checkOk();
}
</script>
</head>
<body>
<%@include file="./../../common/header.jspf" %>
		<%@include file="./../../common/submenu.jspf" %>
<div id="notice-main">
<h2 style="margin-left: 800px;">공지사항</h2>
<form method="get" action="<%=root %>/notice/add.lms" name="form">
	<table id="salesList" style="width: 1200px; margin-left: 285px;">
					<tr  style="text-align: center; background-color: #eeeeee; height: 34px;">
						<th style="width: 110px;">제목</th>
						<th style="width: 900px;"><input id="sub" name="sub" type="text" placeholder="제목을 입력해주세요"  style="width: 900px; height: 26px;"></th>
						<th style="background-color: #BEBEBE;"><input id="topstate" name="topstate" type="checkbox" value="1" style="width: 23px; height: 23px;"></th>
						<th style="background-color: #BEBEBE; text-align: left;"><span>상단 노출</span></th>
					</tr>
					<tr>
						<td colspan="4"><textarea id="content" name="content" cols="168" rows="22" style="resize: none" placeholder="내용을 입력해주세요"></textarea></td>
					</tr>	
	</table>
	
	
	<div style="margin-left: 760px;">
	<input type="button" value="등 록" style="border: 1px solid #3498DB; background-color: #3498DB;color: white;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;" onclick="check()">
	<button style="border: 1px solid #3498DB; background-color: #3498DB;border-radius: 5px; width: 80px; height: 30px; font-weight: bold;"><a style="color: white; text-decoration: none;" href="/LMS6jo/notice/list.lms">뒤 로</a></button>
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