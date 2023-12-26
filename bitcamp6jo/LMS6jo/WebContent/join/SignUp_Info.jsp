<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" type="text/css" href="./../css/SignUp.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkValue(){
		if(document.getElementById("userID").value==""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if(document.getElementById("confmResult").value!="0"){
	         alert("아이디 중복확인을 하시기 바랍니다");
	         return false;
		}
		if(document.getElementById("userPassword1").value==""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		if(document.getElementById("userPassword2").value==""){
			alert("비밀번호 확인을 입력해주세요.");
			return false;
		}
		if(document.getElementById("userPassword1").value!=document.getElementById("userPassword2").value){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		if(document.getElementById("pwfno").value==""){
			alert("비밀번호 찾기 질문을 선택해주세요.");
			return false;
		}
		if(document.getElementById("pwA").value==""){
			alert("비밀번호 찾기 답변을 입력해주세요.");
			return false;
		}
		if(document.getElementById("name").value==""){
			alert("이름을 입력해주세요.");
			return false;
		}
		if(document.getElementById("name").value.length>20){
			alert("이름을 확인해주세요.");
			return false;
		}
		if(document.getElementById("sex").value==""){
			alert("성별을 선택해주세요.");
			return false;
		}
		if(document.getElementById("cp2").value==""){
			alert("휴대전화 번호를 입력해주세요.");
			return false;
		}
		if(document.getElementById("cp3").value==""){
			alert("휴대전화 번호를 입력해주세요.");
			return false;
		}
		if(document.getElementById("email1").value==""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		if(document.getElementById("email2").value==""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		if(document.getElementById("subno").value==""){
			alert("강좌를 선택해주세요.");
			return false;
		}
		checkOk();
	}
	function confirmId(){
		var input=document.getElementById("userID").value;
		window.name="joinParent";
		if(input.length===0){
            alert("아이디를 입력해 주세요");
         }else if(input.length<4){
            alert("아이디는 4자이상으로 입력해 주세요.");
         }else{
		window.open('/LMS6jo/join/confirmId.bit?id='+input,"joinChild",'width=500,height=300,left=500,top=200,resizable=0');
         }
     }
	function chgId(){
        document.getElementById("confmResult").value=0;
        return;
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
	<div class="container" style="margin-left: 570px;">
        <form method="get" action="<%=root %>/join/signupInfo.lms" name="form">
            <table id="info-table"> 
            <tbody>
                <tr>
                    <td><h5>아이디</h5></td>
                    <td><input id="userID" name="id" style="width: 200px; height: 20px;" placeholder="아이디를 입력해주세요." onchange="chgId()">
                    <button id="btn1" type="button" onclick="confirmId()">중복체크</button></td>
                </tr>
                <tr>
                    <td><h5>비밀번호</h5></td>
                    <td><input type="password" id="userPassword1" name="pw1" style="width: 200px; height: 20px;" placeholder="비밀번호를 입력해주세요."></td>
                </tr>
                <tr>
                    <td><h5>비밀번호확인</h5></td>
                    <td><input type="password" id="userPassword2" name="pw2"style="width: 200px; height: 20px;" placeholder="비밀번호 확인을 입력해주세요."></td>
                </tr>
                <tr>
                    <td><h5>비밀번호 찾기 질문</h5></td>
                    <td>
                       <select name="pwfno" id="pwfno" style="width: 200px; height: 25px;">
                        <option value="">선택하세요</option>
                        <option value="1">첫번쨰</option>
                        <option value="2">두번째</option>
                        <option value="3">세번째</option>
                    </select></td>
                </tr>
                <tr>
                    <td><h5>답</h5></td>
                    <td><input name="pwA" id="pwA" type="text"/style="width: 200px; height: 20px;" placeholder="답변을 입력해주세요."></td>
                </tr>
                <tr>
                    <td><h5>이름</h5></td>
                    <td><input name="name" id="name" type="text" style="width: 200px; height: 20px;" placeholder="이름 입력해주세요." onkeyup="chkword(this,6)"/></td>
                </tr>
             
                
                <tr>
                    <td><h5>성별</h5></td>
                    <td><select name="sex" id="sex"style="width: 200px; height: 24px;">
                        <option value="">성별</option>
                        <option value="1">남</option>
                        <option value="2">여</option>
                    </select></td>
                </tr>
                <tr>
                    <td><h5>휴대전화</h5></td>
                    <td><select name="cp1" id=""style="width: 60px; height: 24px;">
                        <option selected="selected" value="010">010</option>
                        <option value="011">011</option>
                        <option value="017">017</option>
                    </select> - <input type="text" name="cp2" id="cp2" style="width: 60px; height: 20px;"/> - <input type="text"style="width: 60px; height: 20px;" name="cp3"  id="cp3" /></td>
                </tr>
                <tr>
                    <td><h5>이메일</h5></td>
                    <td><input type="text"style="width: 80px; height: 20px;" name="email1" id="email1"/>@<select name="email2" id="email2"style="width: 140px; height: 24px;">
                        <option value="">선택하세요</option>
                        <option value="naver.com">naver.com</option>
                        <option value="gmail.com">gmail.com</option>
                    </select></td>
                </tr>
                <tr>
                    <td><h5>강좌선택</h5></td>
                    <td><select name="subno" id="subno"style="width: 240px; height: 24px;">
                        <option value="">선택하세요</option>
                        <option value="1">자바</option>
                        <option value="2">DB</option>
                        <option value="3">WEB</option>
                    </select></td>
                </tr>
                <tr>
                    <td><h5>가입경로</h5></td>
                    <td><input type="radio" checked="checked" name="joinPath" value="1"/>인터넷광고
                    <input type="radio" name="joinPath" value="2"/>고용센터 추천
                    <input type="radio" name="joinPath" value="3"/>지인추천
                    </td>
                </tr>
                <tr>
                    <td><h5>확인코드</h5></td>
                    <td><input type="text"style="width: 200px; height: 20px;" placeholder="강사만 입력해주세요."/></td>
                </tr>
                <tr><td style="height: 30px"></td></tr>
                <tr>
                	<input type="hidden" name="confmResult" id="confmResult"/>
                    <td style="text-align: center;" colspan="2"><input id="btn2" type="button" onclick="checkValue()" value="회 원 가 입"></td>
                </tr>
                
            </tbody>
            </table>
	        <script>
	        	function checkOk(){
	        		document.form.submit();
	        	}
	        </script>
        </form>
        </div>
<%@ include file="./../common/footer.jspf" %>  
</body>
</html>
