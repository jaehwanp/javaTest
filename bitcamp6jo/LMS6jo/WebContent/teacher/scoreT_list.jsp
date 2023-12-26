<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/header.jspf" %>
	<div id="content">
		<%@include file="./../common/submenu.jspf" %>
		<script type="text/javascript">
			//더블클릭했을 때.
			function dbClick(){
				$('.select').index();
	        	$( 'td:nth-child(8)' ).attr('id', 'score');
	    		
				var score = document.querySelector('td:nth-child(8)').childNodes[0].nodeValue; //score
				var target='<td><input style="width:100%;" type="text" onkeyup="enterKey();" id="score" value="'+score+'"/></td>'
				$('#score').replaceWith(target);
			} 
			
			function enterKey(){
				//엔터키 눌렀을 때 
		        if (window.event.keyCode == 13) {
		        	var score = $( '#score' ).val();
		        	//validation check
		        	if(score == ''){
		        		alert('점수를 입력해주시기 바랍니다.');
		        		return;
		        	}else if(!(0 <= score && score <= 100)){
		        		alert('점수를 입력해주시기 바랍니다.(범위:0점~100점)');
		        		return;
		        	}
		        	
		        	var selectScore = document.querySelector('td:nth-child(8)');
		        	$( '#score' ).replaceWith(score);
		        	$( 'td:nth-child(8)' ).attr('ondblclick', 'dbClick()');
		        	$( 'td:nth-child(8)' ).attr('id', 'score');
		        }		
			} 
		</script>
		<div id="subContent">
		<div class="list_div">
			<table class="type13">
				<thead>
					<tr>
						<th>번호</th>
						<th>과정명</th>
						<th>시험명</th>
						<th>이름</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>수정일자</th>
						<th>성적</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>java반</td>
						<td>1차</td>
						<td>황인준</td>
						<td>강사</td>
						<td>2019-07-01</td>
						<td>2019-07-02</td>
						<td class="select" ondblclick="dbClick();">60</td>
					</tr>
				</tbody>
			</table>
			<button class="input_btn">입력</button>
		</div>
    </div>
<%@include file="./../common/footer.jspf" %>