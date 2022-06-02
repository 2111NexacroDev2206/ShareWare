<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업무현황 목록페이지</title>
<link href="/resources/css/work/work-list.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
	<h2 id="w-title">업무진행현황</h2>
	<div>
		<span class="type ${status eq 'all' ? 'active' : ''}"><a href="/project/workList.sw?projectNo=${projectNo }">전체</a></span>
		<span class="type ${status eq 'myList' ? 'active' : ''}"><a href="/project/workList.sw?projectNo=${projectNo }&status=myList">내가 쓴 글</a></span>
		<button id="write-btn" onclick="location.href='/project/workWriteView.sw?projectNo=${projectNo }'">글작성</button>
	</div>
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
			<c:forEach items="${wList }" var="work" varStatus="status">
				<tr>
					<td>${pi.totalCount - (pi.currentPage - 1)*pi.docLimit - status.index}</td>
					<c:url var="wDetail" value="/project/workDetail.sw">
						<c:param name="workNo" value="${work.workNo }"></c:param>
						<c:param name="projectNo" value="${projectNo }"></c:param>
					</c:url>
					<td><a href="${wDetail }">${work.workTitle }</a></td>
					<td>${work.workDate }</td>
					<td>${work.workWriter }</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
	<div class="paging">
				<c:if test="${pi.startNavi ==1 }">
					<a href="/project/workList.sw?projectNo=${projectNo }&page=1"></a>
				</c:if>
				<c:if test="${pi.prev}">
					<a href="/project/workList.sw?projectNo=${projectNo }&page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
				</c:if>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/project/workList.sw?projectNo=${projectNo }">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
				</c:forEach>
				<c:if test="${pi.next && pi.endNavi > 0}">
					<a href="/project/workList.sw?projectNo=${projectNo }&page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
				</c:if>
			</div>
	</div>
</body>
</html>