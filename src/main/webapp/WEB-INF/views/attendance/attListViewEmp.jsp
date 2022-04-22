<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("a hh:mm:ss");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= sf.format(nowTime) %>
	<br>
	<form action="/attendance/registerAtt.sw" method="post">
		<div id="">
			<input type="submit" id="button1" value="출근">
			<input type="submit" id="button2" value="퇴근">
		</div> <br>
		
		<div>
			<table border="1">
				<tr>
					<th>날짜</th>
					<th>출근시간</th>
					<th>퇴근시간</th>
					<th>근무시간</th>
					<th>근무상태</th>
				</tr>
				<c:forEach items="${aList }" var="attendance">
					<tr>
					<td>${attendance.attDate }</td>
					<td>${attendance.attStrTime }</td>
					<td>${attendance.attFinTime }</td>
					<td>${attendance.attTotalTime }</td>
					<td>${attendance.attStatus }</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
	</form>
	
</body>
</html>