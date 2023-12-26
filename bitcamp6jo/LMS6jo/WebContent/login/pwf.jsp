<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type="text/css" href="./../css/login.css">
<script type="text/javascript">
	function pwf(){
		if(document.getElementById("loginID").value==""){
			alert("아이디를 입력해주세요");
			return false;
		}
		if(document.getElementById("pwfno").value==""){
			alert("비밀번호 찾기 질문을 선택해주세요");
			return false;
		}
		if(document.getElementById("pw-anser").value==""){
			alert("질문의 답변을 입력해주세요");
			return false;
		}
		checkOk();
	}
</script>
</head>
<body>
<%@ include file="./../common/header.jspf" %>
<div id="login-container">
	<form action="<%=root %>/login/pwf.lms" method="get" name="form">
    <table id="toptable">
       <tbody>
        <tr>
            <td colspan="2"><h2>비밀번호 찾기</h2></td>
        </tr>
        <tr>
            <td colspan="2"><input  id="loginID" name="id"  type="text" placeholder="아 이 디"></td>
        </tr>
        <tr>
            <td colspan="2" style="height: 40px; vertical-align: bottom">비밀번호 찾기 질문</td>
        </tr>
        <tr><td colspan="2"><select name="pwfno" id="pwfno" style="width: 354px; height: 40px;">
            <option value="">선택하세요</option>
            <option value="1">첫번째</option>
            <option value="2">두번째</option>
            <option value="3">세번째</option>
        </select></td>
        </tr>
        <tr>
            <td colspan="2" style="height: 40px; vertical-align: bottom">답</td>
        </tr>
        <tr>
            <td><input id="pw-anser" name="pwa" type="text" placeholder="질문의 답변을 입력해 주세요."></td>
        </tr>
        </tbody>
    </table>
       <table>
       <br>
        <tr>
            <td style="width: 350px; text-align: center;"><input type="button" id="nextbtn" value="다 음" onclick="pwf()"></td>
        </tr>
        </table>
           <script>
			function checkOk(){
				//체크완료시 submit
				document.form.submit();
			}
		</script>
        </form>
        </div>
        <br><br><br><br>
<%@ include file="./../common/footer.jspf" %>  
<%
	String param=request.getParameter("param");
	if(param!=null){
		if("fail".equals(param)){	
	
%> 
	<script>
					alert("입력하신 정보가 정확하지 않습니다. \n다시 확인 바랍니다.");
	</script>
	<%}
	}
	%>
</body>
</html>