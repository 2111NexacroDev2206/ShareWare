<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuBar</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="/resources/css/menubar-style.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Changa:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://kit.fontawesome.com/c7853f4d26.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="menu">
        <p class="share">Share
        <p class="ware">Ware
        <div class="list-item ${myCondition eq 'home' ? 'active' : ''}"><a href="/home.sw">홈</a></div>
        <div class="list-item ${myCondition eq 'project' ? 'active' : ''}"><a href="">프로젝트 관리</a></div>
        <div class="list-item ${myCondition eq 'report' ? 'active' : ''}"><a href="">업무일지</a></div>
        <div class="list-item "><a href="">근태 관리</a></div>
        <div class="list-item"><a href="">조직도</a></div>
        <div class="list-item"><a href="">주소록</a></div>
        <div class="list-item"><a href="">게시판</a></div>
        <div class="list-item"><a href="">회의실 예약</a></div>
        <div class="list-item ${myCondition eq 'approval' ? 'active' : ''}"><a href="/approval/draftListView.sw">전자결재</a></div>
        <div class="list-item"><a href="">채팅</a></div>
        <div class="list-item"><a href="">일정</a></div>
        <div class="list-item"><a href="">메일</a></div>
    </div>
    <div class="header">
   		<div class="header-right">
	    	<span class="material-icons"style="font-size:45px;">
				mail_outline
			</span>
	    	<span class="material-icons" style="font-size:45px;">
				notifications_none
			</span>
			<span class="material-icons" style="font-size:45px;">
				account_circle
			</span>
			<a class="user">${loginUser.memberName } 님</a>
		</div>
    </div>
</body>
</html>