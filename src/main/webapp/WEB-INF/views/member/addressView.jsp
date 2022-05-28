<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<link href="/resources/css/approval/appList-style.css" rel="stylesheet">
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
<div class="container">
	<div class="menu-title">
			<p>주소록
			<i class="fa-solid fa-address-book"></i>
		</div>
		<div class="l-search" style="float: left;">
			<form action="/member/searchList.sw" method="get" id="searchList">
				<input type="hidden" name="currentPage" value="1">
				<input type="hidden" name="memberLimit" value="10">
				<select class="l-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="all">전체</option>
					<option value="division">부서</option>
					<option value="rank">직급</option>
					<option value="memberName">이름</option>
				</select>
				<div class="l-input">
					<input type="text" id="s-value" name="searchValue" class="l-text">
					<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
				</div>
			</form>
		</div>
	<table class="t-List" style="width: 1500px;">
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
	<div class="paging" style="margin-left:0;width:100%;">
		<!-- 목록 페이징 -->
		<c:if test="${search.searchCondition == null }">
			<c:if test="${pi.startNavi == 1 }">
				<a href="/member/address.sw&page=1"></a>
			</c:if>
			<c:if test="${pi.prev}">
				<a href="/member/address.sw&page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/member/address.sw">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
			</c:forEach>
			<c:if test="${pi.next && pi.endNavi > 0}">
				<a href="/member/address.sw&page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
			</c:if>
		</c:if>
		<!-- 검색한 결과 페이징 -->
		<c:if test="${search.searchCondition != null }">
			<c:if test="${pi.startNavi == 1 }">
				<a href="/member/searchList.sw?page=1&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }"></a>
			</c:if>
			<c:if test="${pi.prev}">
				<a href="/member/searchList.sw?page=${pi.startNavi-1}&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }"><button class="page-btn">Prev</button></a>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/member/searchList.sw?searchCondition=${search.searchCondition }&searchValue=${search.searchValue }">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
			</c:forEach>
			<c:if test="${pi.next && pi.endNavi > 0}">
				<a href="/member/searchList.sw?page=${pi.endNavi+1}&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }"><button class="page-btn">Next</button></a>
			</c:if>
		</c:if>
	</div>
</div>			
</body>
</html>