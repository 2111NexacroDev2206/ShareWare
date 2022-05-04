<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연차관리</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<td>총연차</td>
				<td>사용연차</td>
				<td>잔여연차</td>
			</tr>
			
			<c:if test="${sessionScope.memNum eq member.memNum }">
			<tr>
				<c:forEach items="${ }" var="">
							<td>${appStats.appCount}</td>
				</c:forEach>
			</tr>	
			</c:if>
		</table>
	</div>
		
	<div>
		<table border="1">
			<tr>
				<th>휴가종류</th>
				<th>사용일자</th>
				<th>사용일 수</th>
			</tr>
			<c:forEach items="${lList }" var="leaveResultMap">
			<c:if test="${sessionScope.memNum eq member.memNum }">
			<tr>
				<td>${leave.leaveNo }</td>
				<td>${leave.leaveType }</td>
			
			</tr>
			</c:if>
			</c:forEach>
		</table>
	</div>
</body>
</html>