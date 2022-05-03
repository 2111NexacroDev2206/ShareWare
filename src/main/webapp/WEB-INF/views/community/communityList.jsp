<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 리스트</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>게시글 목록(임시)</h1>
<button onclick="location.href='/community/WriteView.sw'">글 작성</button>
<!-- <a href="/community/WriteView.sw">게시글 작성</a> -->
<br>
<form>
	<table align="center" border="1">
	<tr>
		<th>번호</th>
		<th width="300">제목</th>
		<th>작성자</th>
		<th>작성일</th>
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
	<select name="search">
		<option value="">선택</option>
		<option value="">작성자</option>
		<option value="">제목</option>
	</select>
	<input type="text" id="searchBox">

</form>

	
</body>
</html>