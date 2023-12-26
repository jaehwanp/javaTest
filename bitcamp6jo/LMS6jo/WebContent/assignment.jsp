<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel= "stylesheet" type="text/css" href="css/list.css">
<%@include file="../common/header.jspf" %>
		
	<div id="leftMenu">
        <ul>
            <li><a class="active">마이페이지</a></li>
            <li><a href="<%=root%>/user/attend.jsp">출결확인</a></li>
            <li><a href="<%=root%>/user/assignment.jsp">과제제출</a></li>
            <li><a href="##">학습자료다운</a></li>
            <li><a href="##">성적확인</a></li>
            <li><a href="##">QnA</a></li>
            <li><a href="##">회원탈퇴</a></li>
        </ul>
    </div>

	<div id="content">
    	<div id="subContent">
    	<ul>
    		<li><h2>과제제출</h2></li>
    	</ul><!-- 머야;;왜 리스트 쩜 안생겨.. -->
			<div class="list_div">
				<!--  <h1>과제관리</h1>-->
				<table class="type11">
					<thead>
						<tr>
							<th>번호</th>
							<th>과제명</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>파일여부</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td><a href="">과제입니다1</a></td>
							<td>학생1</td>
							<td>2019-07-02</td>
							<td><a href="#"><i class="fa fa-file-text-o"></i></a></td>
						</tr>
					</tbody>
				</table>
			</div>
	    	<div id="assign_write">
	    		<p class="btn_p">
					<a href="#"><button class="list_btn">글쓰기</button></a>
				</p>
	    	</div>
	    	<div id="searchform">
	    		<form>
		            <select name="opt">
		                <option value="0">제목</option>
		                <option value="1">내용</option>
		                <option value="2">제목+내용</option>
		                <option value="3">글쓴이</option>
		            </select>
		            <input type="text" size="20" name="condition"/>&nbsp;
		            <input class="list_btn" type="submit" value="검색"/>
		        </form>   
	    	</div>
	    	
	    <!-- 페이지 넘버부분 수정해야함!!!!! -->
	    	<div id="pageform">
	    		<c:if test="${startPage != 1}">
		            <a href='BoardListAction.bo?page=${startPage-1}'><button class="list_btn">&lt; </button></a>
		        </c:if>
		        
		        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
		            <c:if test="${pageNum == spage}">
		                ${pageNum}&nbsp;
		            </c:if>
		            <c:if test="${pageNum != spage}">
		                <a href='BoardListAction.bo?page=${pageNum}'>${pageNum}&nbsp;</a>
		            </c:if>
		        </c:forEach>
		        
		        <c:if test="${endPage != maxPage }">
		            <a href='BoardListAction.bo?page=${endPage+1 }'><button class="list_btn">&gt; </button></a>
		        </c:if>

	    	</div>
		</div>
    	
    </div>
<%@include file="../common/footer.jspf" %>
