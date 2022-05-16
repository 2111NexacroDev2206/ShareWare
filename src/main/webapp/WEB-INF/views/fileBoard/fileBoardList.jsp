<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 리스트</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/fileBoaed/fileBoaedList-style.css">
</head>
<body>
<h1>게시글 목록(임시)</h1>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>자유게시판
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'community' ? 'active' : ''}"><a href="/community/list.sw?docStatus=전체">자유게시판</a></div>
		<div class="s-list-item ${listCondition eq 'notice' ? 'active' : ''}"><a href="/notice/list.sw?docStatus=전체">공지게시판</a></div>
		<div class="s-list-item ${listCondition eq 'fileBoard' ? 'active' : ''}"><a href="/fileBoard/list.sw?docStatus=전체">자료실</a></div>
	</div>
	<div id="marging">
	</div>
	<div id="coreDiv">
		<div id="position">
			<div id="contents">
				<div id="writeBtnDiv">
					<button onclick="location.href='/fileBoard/WriteView.sw'">글 작성</button>
				</div>
					<!-- <a href="/community/WriteView.sw">게시글 작성</a> -->
				<br>
				
					<table align="center" class="type04">
					<tr>
						<th colspan="2">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
							<c:forEach items="${fList }" var="fileBoard">
									<tr>
										<td class="comNoTd">${fileBoard.fileBoardNo} </td>
											<c:url var="fDetail" value="/fileBoard/detail.sw">
												<c:param name="fileBoardNo" value="${fileBoard.fileBoardNo }"></c:param>
											</c:url>
										<td class="comTitleTd"><a href ="${fDetail}">${fileBoard.fileBoardTitle }</a></td>
										<td class="defualtTd">${fileBoard.member.memberName }</td>
										<td class="defualtTd">${fileBoard.fileBoardDate }</td>
										<td class="defualtTd">${fileBoard.fileBoardView }</td>
									</tr>
							</c:forEach>
					</table>
					<table>
							<tr align="center" height="20">
							<td colspan="6">
								<c:if test="${pi.prev == true }">
										<a href='<c:url value="/fileBoard/list.sw?page=${pi.startNavi-1 }"/>'>이전</a>
								</c:if>
				
								<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
									<c:url var="pagination" value="/fileBoard/list.sw">
										<c:param name="page" value="${p }"></c:param>
									</c:url>
									<a href="${pagination }">${p }</a>&nbsp;
								</c:forEach>
								<c:if test="${pi.next == true}">
									<a href='<c:url value="/fileBoard/list.sw?page=${pi.endNavi+1 }"/>'>다음</a>
								</c:if>
							</td>
						</table>
					</div>
				</div>
			</div>
</div>
<script>
</script>


	</body>
</html>