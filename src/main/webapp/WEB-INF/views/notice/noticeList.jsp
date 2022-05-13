<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>게시글 목록(임시)</h1>
<br>

	<table align="center" border="1">
	<tr>
		<th>번호</th>
		<th width="300">제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
			<c:if test ="${fn:length(nList) eq 0}"> <!-- list의 길이를 구해서 길이가 0이면 해당 문구를 출력 -->
				<tr>
					<td colspan = "5">검색 정보가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${nList }" var="notice">
					<tr>
						<td>${notice.noticeNo} </td>
							<c:url var="nDetail" value="/notice/detail.sw">
								<c:param name="noticeNo" value="${notice.noticeNo }"></c:param>
							</c:url>
						<td><a href ="${nDetail}">${notice.noticeTitle }</a></td>
						<td>${notice.member.memberName }</td>
						<td>${notice.noticeDate }</td>
						<td>${notice.noticeView }</td>		
					</tr>
			</c:forEach>
	</table>
		
	<jsp:include page="noticePaging.jsp"></jsp:include>
	<form action="/notice/search.sw" method="get" name="searchForm">
		<select name="searchCondition">
			<option value="all">전체</option>
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="contents">내용</option>
	</select>
		
	<input type="text" onkeypress="JavaScript:press(this.search)" name="searchValue">
	<button type="submit">검색</button>
	</form>


<script>

	function search(f){
		if(f.keyCode == 13){ //javascript에서는 13이 enter키를 의미함 
		searchForm.submit(); //formname에 사용자가 지정한 form의 name입력 
		}
	}
	</script>
</body>
</html>