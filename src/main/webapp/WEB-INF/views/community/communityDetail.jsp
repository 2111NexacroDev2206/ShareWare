<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세보기</title>
</head>
<body>
	<h1>자유게시판</h1>
	<br><br>
	<a href ="/community/communityDetil">글작성</a>
	<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${cList }" var="community"> <!-- 반복문 -->
	<tr>
		<td>${community.comNo} </td>
		<c:url var="cDetail" value="/community/community/detail.sw">
			<c:param name="communityNo" value="${community.comNo }"></c:param>
		</c:url>
		<td>${community.comTitle }</td>
		<td>${community.memberNum }</td>
		<td>${community.comDate }</td>
		<td>${community.comView }</td>		
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>