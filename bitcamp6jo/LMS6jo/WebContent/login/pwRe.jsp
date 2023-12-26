<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type="text/css" href="./../css/login.css">
<script type="text/javascript">
	function pwRe(){
		if(document.getElementById("pw1").value==""){
			alert("새 비밀번호를 입력해주세요");
			return false;
		}
		if(document.getElementById("pw2").value==""){
			alert("새 비밀번호 확인을 입력해주세요");
			return false;
		}
		if(document.getElementById("pw1").value!=document.getElementById("pw2").value){
			alert("입력하신 비밀번호가 서로 일치하지 않습니다");
			return false;
		}
		checkOk();
	}
	function chkword(obj, maxlength){
		var str = obj.value; // 이벤트가 일어난 컨트롤의 value 값
		var str_length = str.length; // 전체길이       // 변수초기화     
		var max_length = maxlength; // 제한할 글자수 크기     
		var i = 0; // for문에 사용     
		var ko_byte = 0; // 한글일경우는 2 그밗에는 1을 더함     
		var li_len = 0; // substring하기 위해서 사용     
		var one_char = ""; // 한글자씩 검사한다     
		var str2 = ""; // 글자수를 초과하면 제한할수 글자전까지만 보여준다.       
			for (i = 0; i < str_length; i++) {         // 한글자추출        
			one_char = str.charAt(i);             
			ko_byte++;         
			}// 전체 크기가 max_length를 넘지않으면         
			if (ko_byte <= max_length) {
				li_len = i + 1;         
				}// 전체길이를 초과하면     
			if (ko_byte > max_length) {
				
				alert(max_length + " 글자 이상 입력할 수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. ");         
				str2 = str.substr(0, max_length);         
				obj.value = str2;     
				}    
			obj.focus();  
			}
</script>
</head>
<body>
<%@ include file="./../common/header.jspf" %>
<div id="login-container">
	<form action="<%=root %>/login/pwRe.lms" method="get" name="form">
    <table id="toptable">
       <tbody>
        <tr>
            <td colspan="2"><h2>비밀번호 재설정</h2></td>
        </tr>
       <tr>
           <td>
               <h3 style="width: 70px;">아이디 :</h3>
           </td>
            <td style="width: 280px;"><h3 style="color: #3498DB"><%=request.getParameter("param") %></h3></td>
       </tr>
        <tr>
            <td colspan="2" style="height: 60px;"><input  id="pw1" name="pw1"  type="password" placeholder="새 비밀번호" onkeyup="chkword(this,20)"></td>
        </tr>
        <tr>
            <td colspan="2"><input  id="pw2" name="pw2"  type="password" placeholder="새 비밀번호 확인" onkeyup="chkword(this,20)"></td>
            <input type="hidden" name="id" value="<%=request.getParameter("param") %>">
        </tr>

        </tbody>
    </table>
       <table>
       <br>
        <tr>
            <td style="width: 350px; text-align: center;"><input type="button" id="nextbtn" value="확 인" onclick="pwRe()"></td>
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

</body>
</html>