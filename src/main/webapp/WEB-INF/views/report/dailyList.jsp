<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 목록</title>
</head>
<body>
	<div>
		<h1>일일 업무목록</h1>
	</div>
	<div>
		<table align="center" width="" border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dList }" var="daily"> 
				<tr>
					<td>${daily.drNo }</td>
					<%-- <c:url var="" value="">
						<c:param name="drNo" value="${daily.drNo }"></c:param>
					</c:url> --%>			
					<td><a href="">${daily.drTitle }</a></td>
					<td>${daily.drDate }</td>
					<td>${daily.drWriter }</td>	
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>