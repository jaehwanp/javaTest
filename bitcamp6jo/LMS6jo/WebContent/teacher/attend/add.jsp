<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<%@include file="./../../common/header.jspf" %>
<script>
      $( document ).ready( function() {
        $( '.check_all' ).click( function() {
          $( '.attend_cb' ).prop( 'checked', this.checked );
        } );
      } );
    </script>
	<div id="content">
	<div class="list_div">
		<%@include file="./../../common/submenu.jspf" %>
		<div id="subContent">
			<h2>출결관리</h2>
			<div class="attend_div">
				<div class="div_select_month">
	    		<form>
		            <select name="opt_month">
		                <option value="0">월 선택</option>
		                <option value="1">6월</option>
		                <option value="2">7월</option>
		                <option value="3">8월</option>
		            </select>
		            <select name="opt_day">
		                <option value="0">일 선택</option>
		                <%for(int i=1; i<32;i++){ %>
		                <option value="<%=i%>일"><%=i%></option>
		                <%} %>
		            </select>
		        </form>   
	    		</div>
			<table class="">
			<form>
				<thead>
					<tr>
						<th rowspan=2>번호</th>
						<th rowspan=2>학생이름</th>
						<%for(int i=1; i<32; i++){ %>
						<th><%=i%></th>
						<%} %>
					</tr>
					<tr>
						<%for(int i=1; i<32; i++){
						if(i==8){%>
						<th><input type="checkbox" name="all" class="check_all"></th>
						<%}else{%>
						<th></th>
						<%}
						}  %>
					</tr>
				</thead>
				<tbody>
					<%for(int j=1;j<5;j++){ %>
					<tr>
						<td><%=j %></td>
						<td>학생<%=j %></td>
						<%for(int i=1; i<32; i++){
						if(i==8){%>
						<td><input type="checkbox" name="cb<%=i %>" class="attend_cb"></td>
						<%}else{%>
						<td></td>
						<%}
						}  
					}%>
					</tr>
				</tbody>
			</form>
			</table>
			
			<div class="div_select_month">
				<form>
		            <select name="opt_attend">
		                <option value="0">선택</option>
		                <option value="1">출석</option>
		                <option value="2">지각</option>
		                <option value="3">조퇴</option>
		                <option value="4">외출</option>
		                <option value="5">결석</option>
		            </select>
		        </form>   
				<input class="list_btn" type="submit" value="저장"/>
			</div>
			<!-- 윗줄에 if걸어서 선택된 조건으로 저장버튼을 누르면 저장되게, 0번일 경우는 팝업띄워서 다시 선택하게 만들면 될것같은디?! -->
			
			</div>
		</div>
    </div>
<%@include file="./../../common/footer.jspf" %>