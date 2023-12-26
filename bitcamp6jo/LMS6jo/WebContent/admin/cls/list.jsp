<%@page import="com.bit.lms.model.dto.UserDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../../common/header.jspf" %>

	<div id="mainA">
		<%@include file="./../../common/submenu.jspf" %>
	    <div id="subContent">
	    <div class="list_div">
        <div class="classA_div">
        
        <div id="beforeClass">
        <table>
            <thead>
            	<tr>
            		<th></th>
            		<th>no.</th>
            		<th>희망강좌</th>
            		<th>이름</th>
            	</tr>
            </thead>
            <tbody>
            <div>
	            <form method="post">
	            	<%
	            	String whatsubb=String.valueOf(request.getAttribute("whatsubb"));
	            	System.out.println(request.getAttribute("whatsubb"));
	            	System.out.println(whatsubb);
	            		if(Integer.parseInt(whatsubb)==1 || request.getAttribute("whatsubb")==null){
	            			session.setAttribute("whatsub", 1);
	            		}else if(Integer.parseInt(whatsubb)==2){
	            			session.setAttribute("whatsub", 2);
	            		}
	            		ArrayList<UserDto> list= (ArrayList<UserDto>)request.getAttribute("list");
	            		for(UserDto udt:list){
	            	%>
	            <tr>
	            	<td> <input type="checkbox" id="c1" name="c1" value="<%=session.getAttribute("whatsub")%>"/>
	            	 <input type="hidden" id="c1no" name="c1no" value="<%=udt.getNum()%>"/></td>
	            	<td><%=udt.getNum()%></td>
	                <td><label for="c1"><%=udt.getSubject() %></label></td>
	                <td><label for="c1"><%=udt.getName() %></label></td>
                </tr> 
                <%} %>
                </div>
            </tbody>
            </table>
                    <div><input class="list_btn" type="submit" value="반배정"/></div>
                </form>
            
            </div><!-- before -->
            
            <div id="middle_div">
            	<form>
                    <select name="ban">
                        <option value="1">java반</option>
                        <option value="2">web반</option>
                    </select>
                    <input class="list_btn" type="submit" value="검색"/>
                </form>
           </div> <!-- middle -->
            
           <form method="post">
           <div id="afterClass">
             <table>
            <thead>
            	<tr>
            		<th></th>
            		<th>no.</th>
            		<th>희망강좌</th>
            		<th>이름</th>
            	</tr>
            </thead>
            
            <tbody>
                
            	<% ArrayList<UserDto> list2= (ArrayList<UserDto>)request.getAttribute("list2");
            		for(UserDto udt:list2){
            	%>
                   <tr>
                   <td><input type="checkbox" id="c2" name="c2" value="<%=udt.getNum()%>"/></td>
                   <td><%=udt.getNum()%></td>
                   <td><label for="c2"><%=udt.getSubject() %></label></td>
                   <td><label for="c2"><%=udt.getName() %></label></td>
                   </tr>
                <%} %>
                </tbody>
                </table>
                    <div><input class="list_btn" type="submit" value="초기화"/></div>
              </div>
              </form>
              
              
            </div>
        </div>        
       </div>
    </div>
<%@include file="./../../common/footer.jspf" %>
