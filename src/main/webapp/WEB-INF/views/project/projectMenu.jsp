<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 소메뉴</title>
<link href="/resources/css/project/project-list.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>프로젝트 관리 
			<i class="fa-solid fa-folder-open"></i>		
		</div>
		<input id="newProjectbtn" type="button" value="프로젝트 생성" onclick="location.href='/project/newProjectView.sw'">
		<div class="s-list-item ${listCondition eq 'All' ? 'active' : ''}"><a href="/project/projectList.sw">전체보기</a></div>
		<div class="s-list-item ${listCondition eq 'yList' ? 'active' : ''}"><a href="/project/projectList.sw?pStatus=Y">진행중인 프로젝트</a></div>
		<div class="s-list-item ${listCondition eq 'nList' ? 'active' : ''}"><a href="/project/projectList.sw?pStatus=N">종료된 프로젝트</a></div>
	</div>
</body>
</html>