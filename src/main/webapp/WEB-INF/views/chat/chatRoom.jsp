<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<c:forEach items="${rList }" var="chatRoom">
					<div class="chatRoom-one" onclick="chatPop(${chatRoom.chatRoomNo})">
						<span class="chatRoomType">
							<c:if test="${chatRoom.chatRoomType == 0}"><!-- 1:1 채팅방 -->
								<span class="material-icons">
									account_circle
								</span>
							</c:if>
							<c:if test="${chatRoom.chatRoomType == 1}"><!-- 1:N 채팅방 -->
								<span class="material-icons">
									supervised_user_circle
								</span>
							</c:if>
						</span>
						<div class="chatRoomContent">
							<div class="chat-title-count">
								<div class="chatRoomTitle">
									<p>${chatRoom.chatRoomTitle }
								</div>
								<div class="chatHeadCount">${chatRoom.headCount }</div>
							</div>
							<span class="chatContent">${chatRoom.chatContent }</span>
						</div>
						<span class="chatDate">${chatRoom.chatDate }</span>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="chatModal.jsp"></jsp:include> <!-- 사용자 초대 모달 -->
	<script>
		// 채팅 팝업
		function chatPop(chatRoomNo) {
			var url = "detail.sw?chatRoomNo=" + chatRoomNo;
			var options = "width = 500px, height = 700px";
		    window.open(url, "", options); // 팝업 이름을 "" 빈값으로 둬야 다른 채팅창을 눌러도 새창으로 열림
		}
	</script>
</body>
</html>