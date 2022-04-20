<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 리스트</title>
</head>
<body>
<h1>게시글 목록(임시)</h1>
<a href="/community/WriteView.sw">게시글 작성</a>
<br>
<table align="center" border="1">
	<tr>
		<th>번호</th>
		<th width="300">제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${cList }" var="community">
	<tr>
		<td>${community.comNo} </td>
		<c:url var="cDetail" value="/community/detail.sw">
			<c:param name="comNo" value="${community.comNo }"></c:param>
		</c:url>
		<td><a href ="${cDetail}">${community.comTitle }</a></td>
		<td>${community.memberNum }</td>
		<td>${community.comDate }</td>
		<td>${community.comView }</td>		
	</tr>
	</c:forEach>
	</table>
</body>
</html>