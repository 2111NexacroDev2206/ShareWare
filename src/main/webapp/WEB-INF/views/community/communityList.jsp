
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
		<div id="coreDiv">
		<div id="marging">
		</div>
			<div id="position">
				<div id="contents">
					<div id="writeBtnDiv">
						<button onclick="location.href='/community/WriteView.sw'">작성</button>
					</div>
					
				<!-- <a href="/community/WriteView.sw">게시글 작성</a> -->
					<table align="center" class="type04">
					<tr>
						<th colspan="2" class="comTitleTd">제목</th>
						<th class="memeberTd">작성자</th>
						<th class="dateTd">작성일</th>
						<th class="viewTd">조회수</th>
					</tr>
							<c:if test ="${fn:length(cList) eq 0}"> <!-- list의 길이를 구해서 길이가 0이면 해당 문구를 출력 -->
								<tr>
									<td colspan = "5">검색 정보가 없습니다.</td>
								</tr>
							</c:if>
							<c:set var="num" value="${totalCount - ((currentPage-1) * 10) }"/>
							<c:forEach items="${cList }" var="community">
									<tr>
										
										<td class="comNoTd">${num }</td>
											<c:url var="cDetail" value="/community/detail.sw">
												<c:param name="comNo" value="${community.comNo }"></c:param>
											</c:url>
										<td class="comTitleTd"><a href ="${cDetail}">${community.comTitle }</a></td>
										<td class="memeberTd">${community.member.memberName }</td>
										<td class="dateTd">${community.comDate }</td>
										<td class="viewTd">${community.comView }</td>
										
									</tr>
									<c:set var="num" value="${num-1 }"></c:set>
							</c:forEach>
					</table>
						
					<jsp:include page="communityPaging.jsp"></jsp:include>
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

