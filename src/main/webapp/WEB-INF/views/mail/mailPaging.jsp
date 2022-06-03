<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징</title>
<style type="text/css">
.paging {
	display: inline-flex;
	height: 40px;
	width: 836px;
	margin-left: 257px;
	justify-content: center;
}
.page-btn {
	width: 40px;
	height: 40px;
	border: none;
	background-color: transparent;
	font-size: 14px;
	margin: 0 5px;
	cursor: pointer;
}
.page-btn:hover, .page-btn.active {
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
}
</style>
</head>
<body>
	<div class="paging">
		<!-- 목록 페이징 -->
		<c:if test="${search.memberNum == null }">
		
			<c:if test="${pi.startNavi == 1 }">
				<a href="/mail/${mailCategory }mailListView.sw?page=1"></a>
			</c:if>
			<c:if test="${pi.prev}">
				<a href="/mail/${mailCategory }mailListView.sw?page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/mail/${mailCategory }mailListView.sw">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>&nbsp;									
			</c:forEach>
			<c:if test="${pi.next && pi.endNavi > 0}">
				<a href="/mail/mailListView.sw?page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
			</c:if>
		</c:if>
		<c:if test="${mail.mailType == 'T'}">
			<c:if test="${pi.startNavi == 1 }">
				<a href="/mail/mailTemListView.sw?page=1"></a>
			</c:if>
			<c:if test="${pi.prev}">
				<a href="/mail/mailTemListView.sw?page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/mail/mailTemListView.sw">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>&nbsp;									
			</c:forEach>
			<c:if test="${pi.next && pi.endNavi > 0}">
				<a href="/mail/mailTemListView.sw?page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
			</c:if>
		</c:if>
		<c:if test="${mail.mailType == 'A'}">
			<c:if test="${pi.startNavi == 1 }">
				<a href="/mail/mailAppListView.sw?page=1"></a>
			</c:if>
			<c:if test="${pi.prev}">
				<a href="/mail/mailAppListView.sw?page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/mail/mailAppListView.sw">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>&nbsp;									
			</c:forEach>
			<c:if test="${pi.next && pi.endNavi > 0}">
				<a href="/mail/mailAppListView.sw?page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
			</c:if>
		</c:if>
		
		<!-- 검색한 결과 페이징 -->
		<c:if test="${search.memberNum != null }">
			<c:if test="${pi.startNavi == 1 }">
				<a href="/mail/${mailCategory }mailSearch.sw?page=1&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }"></a>
			</c:if>
			<c:if test="${pi.prev}">
				<a href="/mail/${mailCategory }mailSearch.sw?page=${pi.startNavi-1}&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }"><button class="page-btn">＜</button></a>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/mail/${mailCategory }mailSearch.sw?searchCondition=${search.searchCondition }&searchValue=${search.searchValue }">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>&nbsp;									
			</c:forEach>
			<c:if test="${pi.next && pi.endNavi > 0}">
				<a href="/mail/${mailCategory }mailSearch.sw?page=${pi.endNavi+1}&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }"><button class="page-btn">＞</button></a>
			</c:if>
		</c:if>
		
		
	</div>
</body>
</html>