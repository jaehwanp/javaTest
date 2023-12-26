<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/header.jspf" %>
	<div id="content">
		<%@include file="./../common/submenu.jspf" %>
		<div id="subContent">
			<center>
				<button class="mainT_btn">출결관리</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn">과제관리</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn">학습자료관리</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn">성적관리</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn">Q&A관리</button>
				<br/><br/>
				
				<button class="mainT_btn2"><a href="<%=root%>/teacher/attendT_list.jsp">출결목록</a></button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="<%=root%>/teacher/subjectT_list.jsp">과제목록</a></button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="<%=root%>/teacher/lmT_list.jsp">학습자료목록</a></button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="<%=root%>/teacher/scoreT_list.jsp">성적목록</a></button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="<%=root%>/teacher/qnaQT_list.lms">Q&A목록</a></button>
				<br/><br/>
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="#">학습자료입력</a></button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="#">성적입력</a></button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="mainT_btn2"><a href="#">답변등록</a></button>
				
			</center>
		</div>
    </div>
<%@include file="./../common/footer.jspf" %>