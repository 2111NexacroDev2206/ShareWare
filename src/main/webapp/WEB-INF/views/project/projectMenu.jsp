<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 소메뉴</title>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>프로젝트 관리 
			<i class="fa-solid fa-folders"></i>
		</div>
		<input type="button" value="프로젝트 생성" onclick="">
		<div class="s-list-item ${listCondition eq 'dailyWrite' ? 'active' : ''}"><a href="">전체보기</a></div>
		<div class="s-list-item ${listCondition eq 'approval' ? 'active' : ''}"><a href="">진행중인 프로젝트</a></div>
		<div class="s-list-item ${listCondition eq 'dailyList' ? 'active' : ''}"><a href="">종료된 프로젝트</a></div>
	</div>
</body>
</html>