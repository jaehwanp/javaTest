<%@page import="com.bit.lms.model.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{text-align: center;}
	#confirmbtn{border: 2px solid #3498DB; background-color: #3498DB; color: white; border-radius: 5px;}
	#useId{border: 2px solid #3498DB; background-color: #3498DB; color: white; border-radius: 5px; width: 100px; height: 40px;}
	#cancleBtn{border: 2px solid #3498DB; background-color: #3498DB; color: white; border-radius: 5px;}
	
</style>
<script type="text/javascript">
	function confirmId(){
		var input=document.getElementById("id").value;
		if(input.length===0){
            alert("아이디를 입력해 주세요");
         }else if(input.length<4){
            alert("아이디는 4자이상으로 입력해 주세요.");
         }else{
        	 location.href="/LMS6jo/join/confirmId.bit?id="+input;
         }
	}
	
	function useId(){
		opener.document.getElementById("confmResult").value=document.getElementById("result").value;
		opener.document.getElementById("userID").value=document.getElementById("id").value;
		this.close();
	}

</script>
</head>
<body>
<%
	String id=request.getParameter("id");
	UserDao dao=new UserDao();
	int result=dao.confirmId(id);
%>
<div id="wrap">
	<br>
	<b><font size="5" color="black">아이디 중복체크</font></b>
	<hr size="1" width="460">
	<br>
	<div>
		<form>
			<input type="text" name="id" id="id" value="<%=id %>">
			<input id="confirmbtn" type="button" value="중복확인" onclick="confirmId()">
		</form>
		<%
			String msg="";
			if(result==0){
				msg="사용가능한 아이디입니다.";
			}else if(result==1){
				msg="이미 사용중인 아이디입니다.";
			}
		%>
		<br>
		<div id="msg"><h5><%=msg %></h5></div>
		<br>
		<%
		if(result==0){
		%>
		<input id="useId" type="button" value="사용하기" onclick="useId()"/><br>
		<%}else if(result==1){ %>
		<input id="cancleBtn" type="button" value="취 소" onclick="window.close()"><br>
		<%} %>
		<input type="hidden" value="<%=result%>" id="result" name="result">
	</div>
	<br>
</div>

</body>
</html>