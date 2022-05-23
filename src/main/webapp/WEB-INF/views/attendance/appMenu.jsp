<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리 소메뉴</title>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>근태관리
			<i class="fa-solid fa-user-clock"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'attendance' ? 'active' : ''}"><a href="/attendance/attListViewEmp.sw">근태관리</a></div>
		<div class="s-list-item ${listCondition eq 'leave' ? 'active' : ''}"><a href="/leave/leaveListView.sw">연차관리</a></div>
	</div>
</body>
</html>