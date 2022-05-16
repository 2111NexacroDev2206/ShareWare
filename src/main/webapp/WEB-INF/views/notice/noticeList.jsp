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
<link rel="stylesheet" href="../../../resources/css/notice/noticeList-style.css">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>공지게시판
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
		
			<table align="center" class="type04">
			<tr>
				<th colspan="2">제목</th>
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
								<td class="comNoTd">${notice.noticeNo} </td>
									<c:url var="nDetail" value="/notice/detail.sw">
										<c:param name="noticeNo" value="${notice.noticeNo }"></c:param>
									</c:url>
								<td class="comTitleTd"><a href ="${nDetail}">${notice.noticeTitle }</a></td>
								<td class="defualtTd">${notice.member.memberName }</td>
								<td class="defualtTd">${notice.noticeDate }</td>
								<td class="defualtTd">${notice.noticeView }</td>		
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
		</div>
	</div>
</div>

<script>

	function search(f){
		if(f.keyCode == 13){ //javascript에서는 13이 enter키를 의미함 
		searchForm.submit(); //formname에 사용자가 지정한 form의 name입력 
		}
	}
	</script>
</body>
</html>