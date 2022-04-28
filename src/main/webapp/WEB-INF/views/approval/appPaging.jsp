<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징</title>
</head>
<body>
	<div class="paging">
		<c:if test="${pi.startNavi == 1 }">
			<a href="/approval/${type }ListView.sw?page=1"></a>
		</c:if>
		<c:if test="${pi.prev}">
			<a href="/approval/${type }ListView.sw?page=${pi.startNavi-1}"><button class="page-btn">Prev</button></a>
		</c:if>
		<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
			<c:url var="pagination" value="/approval/${type }ListView.sw">
				<c:param name="page" value="${p }"></c:param>
			</c:url>
			<a href="${pagination }"><button class="page-btn">${p }</button></a>&nbsp;									
		</c:forEach>
		<c:if test="${pi.next && pi.endNavi > 0}">
			<a href="/approval/${type }ListView.sw?page=${pi.endNavi+1}"><button class="page-btn">Next</button></a>
		</c:if>
	</div>
</body>
</html>