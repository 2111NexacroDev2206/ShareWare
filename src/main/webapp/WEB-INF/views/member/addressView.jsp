<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<link href="/resources/css/approval/appList-style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>

<div class="s-container">
	<h2 id="h-title">주소록</h2><br>
		<form action="/member/searchList.sw" method="get" id="searchList">
			<input type="hidden" name="currentPage" value="1">
			<input type="hidden" name="memberLimit" value="10">
				<select class="l-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="all2">전체</option>
					<option value="division">부서</option>
					<option value="rank">직급</option>
					<option value="memberName">이름</option>
				</select>
			<input type="text" name="searchValue">
			<input type="submit" value="검색">
		</form>
		
	<div id="">
	<table class="t-List">
		<tr>
			<th class="th-1">사원번호</th>
			<th class="th-1">이름</th>
			<th class="th-1">부서</th>
			<th class="th-1">직급</th>
			<th class="th-1">이메일</th>
			<th class="th-1">전화번호</th>
		</tr>
		
		<c:forEach items="${mList }" var="member">
			<tr>
				<td>${member.memberNum }</td>
				<td>${member.memberName }</td>
				<td>${member.division }</td>
				<td>${member.rank }</td>
				<td>${member.mail }</td>
				<td>${member.phone }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
		<div class="paging">
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/member/address.sw">
					<c:param name="page" value="${p}"></c:param>
				</c:url>
				<a href="${pagination }">${p }<button class="page-btn"></button></a>&nbsp;
			</c:forEach>
		</div>
		
		
	</div>
</div>			
</body>
</html>