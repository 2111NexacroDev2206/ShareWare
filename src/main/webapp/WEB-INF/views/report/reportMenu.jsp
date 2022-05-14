<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업무일지 소메뉴</title>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>업무 일지 
			<i class="fa-solid fa-file-pen"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'dailyWrite' ? 'active' : ''}"><a href="/report/dailyWriteView.sw">일일 업무일지 작성</a></div>
		<div class="s-list-item ${listCondition eq 'weekWrite' ? 'active' : ''}"><a href="/report/weekWriteView.sw">주간 업무일지 작성</a></div>
		<div class="s-list-item ${listCondition eq 'dailyList' ? 'active' : ''}"><a href="/report/dailyList.sw">일일 업무현황</a></div>
		<div class="s-list-item ${listCondition eq 'weekList' ? 'active' : ''}"><a href="/report/weekList.sw">주간 업무현황</a></div>
	</div>
</body>
</html>