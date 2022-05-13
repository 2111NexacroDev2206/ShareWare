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
</head>
<body>
<h1>게시글 목록(임시)</h1>
<button onclick="location.href='/fileBoard/WriteView.sw'">글 작성</button>
<!-- <a href="/community/WriteView.sw">게시글 작성</a> -->
<br>

	<table align="center" border="1">
	<tr>
		<th>번호</th>
		<th width="300">제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
			<c:forEach items="${fList }" var="fileBoard">
					<tr>
						<td>${fileBoard.fileBoardNo} </td>
							<c:url var="fDetail" value="/fileBoard/detail.sw">
								<c:param name="fileBoardNo" value="${fileBoard.fileBoardNo }"></c:param>
							</c:url>
						<td><a href ="${fDetail}">${fileBoard.fileBoardTitle }</a></td>
						<td>${fileBoard.member.memberName }</td>
						<td>${fileBoard.fileBoardDate }</td>
						<td>${fileBoard.fileBoardView }</td>
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

<script>
</script>


	</body>
</html>