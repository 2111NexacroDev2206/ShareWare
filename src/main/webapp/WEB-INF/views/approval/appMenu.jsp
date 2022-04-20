<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전자결재 소메뉴</title>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>전자결재
			<i class="fa-solid fa-pen-to-square fa-lg"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}"><a href="">기안 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'approval' ? 'active' : ''}"><a href="">결재 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="">참조 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'temporary' ? 'active' : ''}"><a href="">임시 저장함</a></div>
	</div>
</body>
</html>