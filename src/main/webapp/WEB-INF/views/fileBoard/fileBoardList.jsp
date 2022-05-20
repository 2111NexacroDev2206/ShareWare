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
<link rel="stylesheet" href="../../../resources/css/fileBoard/fileBoardList-style.css">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>자료실
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
					<button onclick="location.href='/fileBoard/WriteView.sw'">작성</button>
				</div>
					<!-- <a href="/community/WriteView.sw">게시글 작성</a> -->				
					<table align="center" class="type04">
					<tr>
						<th colspan="2">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
						<c:set var="num" value="${totalCount - ((currentPage-1) * 10) }"/>
							<c:forEach items="${fList }" var="fileBoard">
									<tr>
										<td class="comNoTd">${num} </td>
											<c:url var="fDetail" value="/fileBoard/detail.sw">
												<c:param name="fileBoardNo" value="${fileBoard.fileBoardNo }"></c:param>
											</c:url>
										<td class="comTitleTd"><a href ="${fDetail}">${fileBoard.fileBoardTitle }</a></td>
										<td class="defualtTd">${fileBoard.member.memberName }</td>
										<td class="defualtTd">${fileBoard.fileBoardDate }</td>
										<td class="defualtTd">${fileBoard.fileBoardView }</td>
									</tr>
									<c:set var="num" value="${num-1 }"></c:set>
							</c:forEach>
					</table>
					<jsp:include page="fileBoardPagin.jsp"></jsp:include>
			</div>
	</div>
</div>
<script>
</script>


	</body>
</html>