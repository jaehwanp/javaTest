<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type="text/css" href="./../css/login.css">
</head>
<body>
<%@ include file="./common/header.jspf" %>
	<div>
	<center>
   <form action="<%=root %>/userdel.lms" method="post">
    <table>
       <tbody>
        <tr>
            <td colspan="2"><h2>회원탈퇴</h2></td>
        </tr>
        <tr>
            <td colspan="2">아이디 <input name="id" type="text" placeholder="아 이 디"></td>
        </tr>
        <tr>
            <td colspan="2">비밀번호 <input name="pw1"  type="password" placeholder="비밀번호"></td>
        </tr>
        </tbody>
    </table>
    	<button type="submit" name="withdrawBtn">확인</button>
    </form>
    </center>
    </div>
<%@include file="../common/footer.jspf" %>