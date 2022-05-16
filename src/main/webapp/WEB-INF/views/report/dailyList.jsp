<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 목록</title>
<link href="/resources/css/report/daily-style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="h-title">일일 업무목록</h2>
			<button id="app-btn" onclick="location.href='/report/dailyWriteView.sw'">일지작성</button>
		<br><br>
		<table class="t-List">
			<thead>
				<tr>
					<th class="th-1">번호</th>
					<th class="th-3">제목</th>
					<th class="th-2">작성일</th>
					<th class="th-2">작성자</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dList }" var="daily" varStatus="status"> 
				<tr>
					<td>${pi.totalCount - (pi.currentPage - 1)*pi.docLimit - status.index}</td>
					<c:url var="drDetail" value="/report/dailyDetail.sw">
						<c:param name="drNo" value="${daily.drNo }"></c:param>
					</c:url>			
					<td><a href="${drDetail}">${daily.drTitle }</a></td>
					<td>${daily.drDate }</td>
					<td>${daily.drWriter }</td>	
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="paging">
				<c:if test="${pi.startNavi ==1 }">
					<a href="/report/dailyList.sw?page=1"></a>
				</c:if>
				<c:if test="${pi.prev}">
					<a href="/report/dailyList.sw?page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
				</c:if>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/report/dailyList.sw">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
				</c:forEach>
				<c:if test="${pi.next && pi.endNavi > 0}">
					<a href="/report/dailyList.sw?page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
				</c:if>
			</div>
	</div>
</body>
</html>