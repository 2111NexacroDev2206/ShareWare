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
		<div class="s-list-item ${listCondition eq 'draft' || listCondition eq 'rej' ? 'active' : ''}"><a href="/approval/draftListView.sw">기안 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'app' ? 'active' : ''}"><a href="/approval/appListView.sw">결재 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'ref' ? 'active' : ''}"><a href="/approval/refListView.sw">참조 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'tem' ? 'active' : ''}"><a href="/approval/temListView.sw">임시 저장함</a></div>
	</div>
</body>
</html>