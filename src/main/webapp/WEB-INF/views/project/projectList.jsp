<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 목록페이지</title>
<link href="/resources/css/project/project-list.css" rel="stylesheet">
</head>
<body>
<jsp:include page="projectMenu.jsp"></jsp:include>
		<div class="s-container">
		<div>
			<h2 id="h-title">나의 프로젝트</h2>
		</div>
			<table class="t-List">
				<thead>
				 	<tr>
				 		<th class="th-1">번호</th>
				 		<th>프로젝트명</th>
				 		<th class="th-1">담당자</th>
				 		<th class="th-2">기간</th>
				 		<th class="th-1">상태</th>
				 	</tr>
				 </thead>
				 <tbody>
				 <jsp:useBean id="now" class="java.util.Date" />
				 <fmt:formatDate value="${now}" pattern="yyyyMMdd" var="nowDate" /> 
				 <c:forEach items="${pList }" var="project" varStatus="status">
					
				 	<tr>
				 		<td>${pi.totalCount - (pi.currentPage - 1)*pi.docLimit - status.index}</td>
				 		<c:url var="pDetail" value="/project/main.sw">
				 			<c:param name="projectNo" value="${project.projectNo }"></c:param>
				 		</c:url>
				 		<td><a href="${pDetail}">${project.projectTitle}</a></td>
				 		<td>${project.projectMade }</td>
				 		<td>${project.pStartDate} ~ ${project.pEndDate}</td>
				 		<td>
							<c:if test="${project.pEndDate >= nowDate  }">
				 				<input type="hidden" value="Y" name="pStatus"><span class="status-Y">진행중</span>
				 			</c:if>
				 			<c:if test="${project.pEndDate < nowDate  }">
							 	<input type="hidden" value="N" name="pStatus" ><span class="status-N">종료</span>
							</c:if>
				 		</td>
				 	</tr>
				 </c:forEach>
				 </tbody>
			</table>
			<c:if test="${search.searchCondition == null }">
				<div class="paging">
					<c:if test="${pi.startNavi ==1 }">
						<a href="/project/projectList.sw?pStatus=${pStatus }&page=1"></a>
					</c:if>
					<c:if test="${pi.prev}">
						<a href="/project/projectList.sw?pStatus=${pStatus }&page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
					</c:if>
					<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
						<c:url var="pagination" value="/project/projectList.sw?pStatus=${pStatus }">
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
					</c:forEach>
					<c:if test="${pi.next && pi.endNavi > 0}">
						<a href="/project/projectList.sw?pStatus=${pStatus }&page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
					</c:if>
				</div>
			</c:if>
			<c:if test="${search.searchCondition != null }">
				<div class="paging">
					<c:if test="${pi.startNavi ==1 }">
						<a href="/project/projectSearch.sw?pStatus=${pStatus }&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }&page=1"></a>
					</c:if>
					<c:if test="${pi.prev}">
						<a href="/project/projectSearch.sw?pStatus=${pStatus }&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }&page=${pi.startNavi-1}"><button class="page-btn">＜</button></a>
					</c:if>
					<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
						<c:url var="pagination" value="/project/projectSearch.sw?pStatus=${pStatus }&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }">
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<a href="${pagination }"><button class="page-btn ${p eq currentPage ? 'active' : ''}">${p }</button></a>
					</c:forEach>
					<c:if test="${pi.next && pi.endNavi > 0}">
						<a href="/project/projectSearch.sw?pStatus=${pStatus }&searchCondition=${search.searchCondition }&searchValue=${search.searchValue }&page=${pi.endNavi+1}"><button class="page-btn">＞</button></a>
					</c:if>
				</div>
			</c:if>
			<div class="l-search">
			<form action="/project/projectSearch.sw" method="get">
				<select class="l-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="docTitle">제목</option>
				</select>
				<div class="l-input">
					<input type="hidden" name="pStatus" value="${pStatus }">
					<input type="text" id="s-value" name="searchValue" class="l-text">
					<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
				</div>
			</form>
		</div>
	</div>
</body>
</html>