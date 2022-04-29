<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
</head>
<body>
		<form action="/member/searchList.sw" align="center" method="get" id="searchList">
			<input type="hidden" name="currentPage" value="1">
			<input type="hidden" name="memberLimit" value="10">
				<select class="form-control" name="searchType"   style="width:60px;height:40px; align:center" >
					<option value="division">부서</option>
					<option value="rank">직급</option>
					<option value="memberName">이름</option>
				</select>
			<input type="text" name="searchKeyword">
			<input type="submit" value="검색">
		</form>
		
	<div id="">
	<table align="center" id="" border="1">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>부서</th>
			<th>직급</th>
			<th>이메일</th>
			<th>전화번호</th>
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
	
		<div id="page">
			[<<]
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/qna/list.mayfly">
					<c:param name="page" value="${p}"></c:param>
				</c:url>
				<a href="${pagination }">${p }</a>&nbsp;
			</c:forEach>
			[>>]
		</div>
		
		
	</div>
			
</body>
</html>