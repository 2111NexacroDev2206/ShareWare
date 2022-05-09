<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<link href="/resources/css/chat/chatRoom-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="container">
		<div class="menu-title">
			<p>채팅
			<i class="fa-solid fa-comments"></i>
		</div>
		<div class="chatRoom">
			<div class="chatRoom-header">
				<span class="chatRoom-title">채팅방 목록</span>
				<button class="chatRoom-button" onclick="chatRoomBtn();">채팅방 생성</button>
			</div>
			<div class="chatRoom-list">
				
			</div>
		</div>
	</div>
	<jsp:include page="chatModal.jsp"></jsp:include> <!-- 사용자 초대 모달 -->
</body>
</html>