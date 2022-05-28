<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 리스트</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/community/communityList-style.css">
</head>
<body>
<jsp:include page="communityMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="h-title">자유게시판 목록</h2>
			<button id="writeBtnDiv" onclick="location.href='/community/WriteView.sw'">작성</button>
		<br><br>
		<table align="center" class="type01">
			<thead>
				<tr>
					<th colspan="2" class="th-3">&nbsp;&nbsp;&nbsp;제 목</th>
					<th class="th-2">작성자</th>
					<th class="th-2">작성일</th>
					<th class="th-1">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test ="${fn:length(cList) eq 0}"> <!-- list의 길이를 구해서 길이가 0이면 해당 문구를 출력 -->
					<tr>
						<td colspan = "5">검색 정보가 없습니다.</td>
					</tr>
				</c:if>
				<c:set var="num" value="${totalCount - ((currentPage-1) * 10) }"/>
				<c:forEach items="${cList }" var="community">
						<tr>
							<td id="no">${num }</td>
								<c:url var="cDetail" value="/community/detail.sw">
									<c:param name="comNo" value="${community.comNo }"></c:param>
								</c:url>
							<td class="td-title"><a href ="${cDetail}">${community.comTitle }</a></td>
							<td>${community.member.memberName }</td>
							<td>${community.comDate }</td>
							<td>${community.comView }</td>
						</tr>
						<c:set var="num" value="${num-1 }"></c:set>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<jsp:include page="communityPaging.jsp"></jsp:include>
		</div>
			<div class="l-search">
				<form action="/community/search.sw" method="get" name="searchForm">
					<select name="searchCondition" class="l-select" style="text-align: left; width: 80px;">
						<option value="all">전체</option>
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="contents">내용</option>
					</select>
						<div id="searchBtn" class="l-input">
							<input type="text" onkeypress="JavaScript:press(this.search)" name="searchValue" class="l-text">
							<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
						</div>
				</form>
			
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

