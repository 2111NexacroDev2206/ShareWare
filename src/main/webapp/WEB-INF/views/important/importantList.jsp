<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  <!-- 넘버  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중요공지 목록</title>
<link href="/resources/css/important/important-list.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
	<h2 id="i-title">중요공지사항</h2>
		<button id="write-btn" onclick="location.href='/project/importantWriteView.sw?projectNo=${projectNo }'" id="#write-btn">공지작성</button>
		<table class="i-List">
			<thead>
				<tr>
					<th class="th-1">번호</th>
					<th class="th-3">제목</th>
					<th class="th-2">작성일</th>
					<th class="th-1">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${iList }" var="important" varStatus="status">
				<tr>
					<td>${pi.totalCount - (pi.currentPage - 1)*pi.docLimit - status.index}</td>
					<c:url var="iDetail" value="/project/importantDetail.sw">
						<c:param name="importantNo" value="${important.importantNo }"></c:param>
						<c:param name="projectNo" value="${projectNo }"></c:param>
					</c:url>
					<td><a href="${iDetail }">${important.importantTitle }</a></td>
					<td>${important.importantDate }</td>
					<td>${important.importantCount }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
			<div class="paging">
				<c:if test="${pi.startNavi ==1 }">
					<a href="/project/importantList.sw?projectNo=${projectNo }&page=1"></a>
				</c:if>
				<c:if test="${pi.prev}">
					<a href="/project/importantList.sw?projectNo=${projectNo }&page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
				</c:if>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/project/importantList.sw?projectNo=${projectNo }">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
				</c:forEach>
				<c:if test="${pi.next && pi.endNavi > 0}">
					<a href="/project/importantList.sw?projectNo=${projectNo }&page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
				</c:if>
			</div>
			<%-- <div>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/project/importantList.sw?projectNo=${projectNo }">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }">${p }</a>&nbsp;
				</c:forEach>
			</div> --%>
	</div>
</body>
</html>