<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type="text/css" href="./../css/login.css">
<script type="text/javascript">
	function confirmLogin(){
		if(document.getElementById("loginID").value==""){
			alert("아이디를 입력해주세요");
			return false;
		}
		if(document.getElementById("loginPW").value==""){
			alert("비밀번호를 입력해주세요");
			return false;
		}
		loginOk();
	}
</script>
</head>
<body>
<%@ include file="./../common/header.jspf" %>
   <div id="login-container">
   <form action="<%=root %>/login/adminlogin.lms" method="get" name="form">
    <table id="toptable">
       <tbody>
        <tr>
            <td colspan="2"><h2>관리자 로그인</h2></td>
        </tr>
        <tr>
            <td colspan="2"><input  id="loginID" name="id" type="text" placeholder="아 이 디"></td>
        </tr>
        <tr>
            <td colspan="2"><input id="loginPW" name="pw"  type="password" placeholder="비밀번호"></td>
        </tr>
        <tr><td colspan="2"><input id="loginbtn" type="button" value="로그인" onclick="confirmLogin()"></td>
        </tr>
        <tr>
        	
            <td colspan="2" style="border-bottom: 2px solid darkgray"><label for=""><a class="atag" href="<%=root%>/login/login.jsp">학생 로그인</a></label></td>
        </tr>
        </tbody>
    </table>
    <script>
			function loginOk(){
				//체크완료시 submit
				document.form.submit();
			}
		</script>
    </form>
       <table>
       <br>
        <tr>
            <td style="width: 175px; height: 25px; text-align: center; border-right:2px solid darkgray "><a class="atag" href="#">비밀번호 찾기</a></td>
            <td style="width: 175px; text-align: center;"><a class="atag" href="<%=root%>/join/SignUp_terms.lms">회원가입</a></td>
        </tr>
        </table>
        </div>
        <br><br><br><br>
<%@ include file="./../common/footer.jspf" %>
<%
	String param=request.getParameter("param");
	if(param!=null){
		if("fail".equals(param)){	
	
%> 
	<script>
					alert("아이디와 비밀번호를 확인하시기 바랍니다");
	</script>
	<%}
	}
	%>  
</body>
</html>