<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세보기</h1>
	<div>
		<span>글번호</span>
		<span>${bean.num }</span>
		<span>글쓴이</span>
		<span>${bean.name }</span>
		<span>날짜</span>
		<span>${bean.nalja }</span>
	</div>
	<div>
		<span>제목</span>
		<span>${bean.sub }</span>
	</div>
	<div>
		<span>${bean.content }</span>
	</div>
	<div>
		<a href="edit.bit?idx=${bean.num }">수정</a>
		<a href="delete.bit?idx=${bean.num }">삭제</a>
	</div>
</body>
</html>