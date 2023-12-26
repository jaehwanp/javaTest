<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel= "stylesheet" type="text/css" href="css/attend.css">
<%@include file="./common/header.jspf" %>
	
	<%@include file="./common/submenu.jspf" %>
	<div id="content">
    	<h2>출결확인</h2>
    	<div id="attend_content">
    	<div id="attend_icon">
    	<img id="user_icon" src="imgs/user_icon.png">
    	</div>
    	<div id="div_progress_bar">
    	<table><!-- 출결확인 윗줄 아이콘 옆 자료 -->
    		<tr>
    			<td colspan=2><h3>수강중인 강좌명</h3></td>
    		</tr>
    		<tr>
    			<td colspan=2>수강 강좌 기간</td>
    		</tr>
    		<tr>
	    		<td>
	    			나의 출석률
	    		</td>
	    		<td>
		    		<DIV class=progress-small>
			    		<DIV role=progressbar aria-valuenow=10 aria-valuemin=0 class="progress-bar-small progress-bar-s-info" style="WIDTH: 60%" aria-valuemax=100> 
			    		<SPAN class=sr-only>60% Complete</SPAN></DIV>
	    		 	</DIV>
	    		 </td>
    		</tr>
    		<tr>
    			<td>전체 수강률</td>
	    		<td>
		    		<DIV class=progress-small>
			    		<DIV role=progressbar aria-valuenow=10 aria-valuemin=0 class="progress-bar-small progress-bar-s-info" style="WIDTH: 80%" aria-valuemax=100> 
			    		<SPAN class=sr-only>80% Complete</SPAN></DIV>
		    		</DIV>
	    		</td>
		</table>
    	</div>
    	
    	<div id="attend_table">
    	as
    	<table class="attendCheck_table" id="attendCheck_table">
    		<tr>
    			<th>출석</th>
    			<th>결석</th>
    			<th>조퇴</th>
    			<th>외출</th>
    			<th>지각</th>
    		</tr>
    		<tr>
    			<td>66</td>
    			<td>1</td>
    			<td>0</td>
    			<td>0</td>
    			<td>4</td>
    		</tr>
    	</table>
    	</div>
    	</div>
    </div>
<%@include file="./common/footer.jspf" %>
